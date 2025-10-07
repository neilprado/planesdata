package br.com.planesdata.mtg.service;

import br.com.planesdata.mtg.models.Download;
import br.com.planesdata.mtg.models.FileData;
import com.azure.json.implementation.jackson.core.JsonFactory;
import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import static br.com.planesdata.mtg.utils.Constants.BASE_URL;
import static br.com.planesdata.mtg.utils.Constants.BULK_DATA;
import static br.com.planesdata.mtg.utils.Constants.FILE_ADDRRESS;

@Service
@RequiredArgsConstructor
public class DownloadService {

    private static final WebClient webClient = WebClient.create(BASE_URL);

    public void generateFile(String fileType) {
        String uri = getDownloadedUri(fileType);
        Path path = Path.of(FILE_ADDRRESS + fileType + ".json");

        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            System.err.println("Erro ao criar diretórios: " + e.getMessage());
        }

        try(WritableByteChannel channel = Files.newByteChannel(
                path,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE)) {

            WebClient.create()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToFlux(DataBuffer.class)
                    .doOnNext(dataBuffer -> {
                        try {
                            channel.write(dataBuffer.asByteBuffer());
                        } catch (IOException e) {
                            throw new RuntimeException("Erro ao escrever no arquivo: " + e.getMessage(), e);
                        } finally {
                            DataBufferUtils.release(dataBuffer);
                        }
                    }).then().block();

            System.out.println("Arquivo salvo em: " + path.toAbsolutePath());

            saveObjectsFromFile(fileType);
            finishSetup(fileType);
        } catch (IOException e) {
            System.err.println("Erro ao abrir arquivo para escrita!! " + e.getMessage());
        }

    }

    private String getDownloadedUri(String fileType) {
        Download download = getDownloadObject();

        Optional<FileData> data = download.getData()
                .stream().
                filter(d -> d.getType().contains(fileType))
                .findFirst();

        return data.get().getDownloadUri();
    }

    private Download getDownloadObject() {
        return webClient.get()
                .uri(BULK_DATA)
                .retrieve()
                .bodyToMono(Download.class)
                .block();
    }

    private void saveObjectsFromFile(String fileType) {
        File file = new File("src/main/resources/static/" + fileType +".json");

        if (!file.exists()) {
            System.err.println("Arquivo não encontrado");

        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonFactory factory = new JsonFactory();

        try (JsonParser parser = factory.createParser(file)) {
            if (parser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("JSON não começa com uma lista!");
            }

            while (parser.nextToken() == JsonToken.START_OBJECT) {
                if (fileType.equals("all_cards")) {
                    Card card = objectMapper.readValue(parser, Card.class);
                    cardRepository.save(card);
                } else {
                    Ruling ruling = objectMapper.readValue(parser, Ruling.class);
                    rulingRepository.save(ruling);
                }
            }

            System.out.println("Importação concluída!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao processar o JSON: " + e.getMessage());

        }
    }

    private void finishSetup(String fileType) {
        try {
            Path path = Path.of("src/main/resources/static/" + fileType +".json");
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
