package br.com.planesdata.mtg.service;

import br.com.planesdata.mtg.models.Card;
import br.com.planesdata.mtg.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    public Page<Card> list(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
