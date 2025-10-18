package br.com.planesdata.mtg.repository;

import br.com.planesdata.mtg.models.Ruling;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RulingRepository extends MongoRepository<Ruling, String> {
}
