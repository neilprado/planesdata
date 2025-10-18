package br.com.planesdata.mtg.service;

import br.com.planesdata.mtg.models.Ruling;
import br.com.planesdata.mtg.repository.RulingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RulingService {

    private final RulingRepository repository;

    public Page<Ruling> list(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
