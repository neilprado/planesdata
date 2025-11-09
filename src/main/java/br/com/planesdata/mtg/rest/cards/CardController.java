package br.com.planesdata.mtg.rest.cards;

import br.com.planesdata.mtg.models.Card;
import br.com.planesdata.mtg.rest.cards.dto.response.CardResponseDTO;
import br.com.planesdata.mtg.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.planesdata.mtg.utils.Constants.API;
import static br.com.planesdata.mtg.utils.Constants.CARDS;
import static br.com.planesdata.mtg.utils.Constants.VERSION;

@RestController
@RequestMapping(value = API + VERSION + CARDS)
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public ResponseEntity<Slice<CardResponseDTO>>list(Pageable pageable) {
        Slice<Card> cards = cardService.list(pageable);
        return ResponseEntity.ok(cards.map(CardResponseDTO::toDto));
    }
}
