package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.Preview;

public record PreviewDTO(
        String source,
        String sourceUri,
        String previewedAt) {

    public static PreviewDTO toDto(Preview model) {
        return new PreviewDTO(
                model.getSource(),
                model.getSourceUri(),
                model.getPreviewedAt());
    }
}
