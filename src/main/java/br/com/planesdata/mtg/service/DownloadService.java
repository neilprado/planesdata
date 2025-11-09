package br.com.planesdata.mtg.service;

import br.com.planesdata.mtg.models.Card;
import br.com.planesdata.mtg.models.Download;
import br.com.planesdata.mtg.models.FileData;
import br.com.planesdata.mtg.models.Ruling;
import br.com.planesdata.mtg.repository.CardRepository;
import br.com.planesdata.mtg.repository.RulingRepository;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static br.com.planesdata.mtg.utils.Constants.BASE_URL;
import static br.com.planesdata.mtg.utils.Constants.BULK_DATA;
import static br.com.planesdata.mtg.utils.Constants.FILE_ADDRRESS;

@Service
@RequiredArgsConstructor
public class DownloadService {

    private static final WebClient webClient = WebClient.create(BASE_URL);
    private final CardRepository cardRepository;
    private final RulingRepository rulingRepository;

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

            saveObjects(fileType, path.toFile());
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

    private void saveObjects(String fileType, File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonFactory factory = new JsonFactory();

        ExecutorService executor = Executors.newFixedThreadPool(32);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        try (JsonParser parser = factory.createParser(file)) {
            if (parser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("JSON não começa com um array!");
            }

            List<Object> batch = new ArrayList<>();
            int BATCH_SIZE = 10000;

            while (parser.nextToken() == JsonToken.START_OBJECT) {
                if (fileType.equals("all_cards")) {
                    batch.add(objectMapper.readValue(parser, Card.class));
                } else {
                    batch.add(objectMapper.readValue(parser, Ruling.class));
                }

                if (batch.size() >= BATCH_SIZE) {
                    List<Object> toSave = new ArrayList<>(batch);
                    batch.clear();

                    futures.add(CompletableFuture.runAsync(() -> saveBatch(toSave, fileType), executor));
                }
            }

            if (!batch.isEmpty()) {
                futures.add(CompletableFuture.runAsync(() -> saveBatch(batch, fileType), executor));
            }

            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            executor.shutdown();

            System.out.println("✅ Importação concluída com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao processar JSON: " + e.getMessage());
        }
    }

    private void saveBatch(List<Object> batch, String fileType) {
        if (batch.isEmpty()) {
            return;
        }

        if (fileType.equals("all_cards")) {
            List<Card> cards = batch.stream()
                    .filter(obj -> obj instanceof Card)
                    .map(obj -> (Card) obj)
                    .toList();
            cardRepository.saveAll(cards);
        } else {
            List<Ruling> rulings = batch.stream()
                    .filter(obj -> obj instanceof Ruling)
                    .map(obj -> (Ruling) obj)
                    .toList();
            rulingRepository.saveAll(rulings);
        }
        System.out.println("Processado " + batch.size() + " registros de " + fileType);
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
