package br.com.planesdata.mtg.rest;

import br.com.planesdata.mtg.service.DownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.planesdata.mtg.utils.Constants.API;
import static br.com.planesdata.mtg.utils.Constants.CARDS;
import static br.com.planesdata.mtg.utils.Constants.CONFIG;
import static br.com.planesdata.mtg.utils.Constants.DOWNLOAD;
import static br.com.planesdata.mtg.utils.Constants.RULINGS;
import static br.com.planesdata.mtg.utils.Constants.VERSION;

@RestController
@RequestMapping(value = API + VERSION + CONFIG + DOWNLOAD)
@RequiredArgsConstructor
public class DataController {

    private final DownloadService downloadService;

    @GetMapping(value = CARDS)
    public ResponseEntity<Void> downloadCardData() {
        downloadService.generateFile("all_cards");

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = RULINGS)
    public ResponseEntity<Void> downloadRulingData() {
        downloadService.generateFile("rulings");

        return ResponseEntity.noContent().build();
    }
}
