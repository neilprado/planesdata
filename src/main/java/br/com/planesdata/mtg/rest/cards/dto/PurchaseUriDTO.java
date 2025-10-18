package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.PurchaseUri;

public record PurchaseUriDTO(
        String tcgplayer,
        String cardmarket,
        String cardhoarder) {

    public static PurchaseUriDTO toDto(PurchaseUri model) {
        return new PurchaseUriDTO(
                model.getTcgplayer(),
                model.getCardmarket(),
                model.getCardhoarder());
    }
}
