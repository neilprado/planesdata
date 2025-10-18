package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    private BigDecimal usd;

    @JsonProperty(value = "usd_foil")
    private BigDecimal usdFoil;

    @JsonProperty(value = "usd_etched")
    private BigDecimal usdEtched;

    private BigDecimal eur;

    @JsonProperty(value = "eur_foil")
    private BigDecimal eurFoil;

    private BigDecimal tix;
}
