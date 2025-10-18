package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.ImageURI;

import java.util.Objects;

public record ImageUriDTO(
        String small,
        String normal,
        String large,
        String png,
        String artCrop,
        String borderCrop) {

    public static ImageUriDTO toDto(ImageURI model) {
        return Objects.isNull(model) ? null : new ImageUriDTO(
                model.getSmall(),
                model.getNormal(),
                model.getLarge(),
                model.getPng(),
                model.getArtCrop(),
                model.getBorderCrop());
    }
}

