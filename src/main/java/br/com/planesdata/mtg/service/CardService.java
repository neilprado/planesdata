package br.com.planesdata.mtg.service;

import br.com.planesdata.mtg.models.Card;
import br.com.planesdata.mtg.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Cacheable(value = "cardsList", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public Slice<Card> list(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
