package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.AllPart;

public record AllPartDTO(
        String type,
        String id,
        String component,
        String name,
        String typeLine,
        String uri) {

    public static AllPartDTO toDto(AllPart model) {
        return new AllPartDTO(
                model.getType(),
                model.getId(),
                model.getComponent(),
                model.getName(),
                model.getTypeLine(),
                model.getUri());
    }
}
