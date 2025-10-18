package br.com.planesdata.mtg.rest.rulings.dto;

import br.com.planesdata.mtg.models.RulingData;

public record RulingDataDTO(
        String type,
        String oracleID,
        String source,
        String publishedAt,
        String comment) {

    public static RulingDataDTO toDto(RulingData model) {

        return new RulingDataDTO(
                model.getType(),
                model.getOracleID(),
                model.getSource(),
                model.getPublishedAt(),
                model.getComment());
    }
}
