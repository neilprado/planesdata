package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.RelatedUri;

public record RelatedUriDTO(
        String gatherer,
        String tcgPlayerInfiniteArticles,
        String tcgPlayerInfiniteDecks,
        String edhrec) {

    public static RelatedUriDTO toDto(RelatedUri model) {
        return new RelatedUriDTO(
                model.getGatherer(),
                model.getTcgPlayerInfiniteArticles(),
                model.getTcgPlayerInfiniteDecks(),
                model.getEdhrec());
    }
}
