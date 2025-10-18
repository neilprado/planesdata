package br.com.planesdata.mtg.rest.rulings;

import br.com.planesdata.mtg.models.Ruling;
import br.com.planesdata.mtg.rest.rulings.dto.RulingResponseDTO;
import br.com.planesdata.mtg.service.RulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.planesdata.mtg.utils.Constants.API;
import static br.com.planesdata.mtg.utils.Constants.RULINGS;
import static br.com.planesdata.mtg.utils.Constants.VERSION;

@RestController
@RequestMapping(value = API + VERSION + RULINGS)
@RequiredArgsConstructor
public class RulingController {

    private final RulingService rulingService;

    @GetMapping
    public ResponseEntity<Page<RulingResponseDTO>>list(Pageable pageable) {
        Page<Ruling> rulings = rulingService.list(pageable);
        return ResponseEntity.ok(rulings.map(RulingResponseDTO::toDto));
    }
}
