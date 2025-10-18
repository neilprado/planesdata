package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.Price;

import java.math.BigDecimal;

public record PriceDTO(
        BigDecimal usd,
        BigDecimal usdFoil,
        BigDecimal usdEtched,
        BigDecimal eur,
        BigDecimal eurFoil,
        BigDecimal tix) {

    public static PriceDTO toDto(Price model) {
        return new PriceDTO(
          model.getUsd(),
          model.getUsdFoil(),
          model.getUsdEtched(),
          model.getEur(),
          model.getEurFoil(),
          model.getTix());
    }
}
