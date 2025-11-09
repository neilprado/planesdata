package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Legality {

    private String standard;
    private String future;
    private String historic;
    private String pioneer;
    private String modern;
    private String legacy;
    private String pauper;
    private String vintage;
    private String penny;
    private String commander;
    private String oathbreaker;
    private String paupercommander;
    private String oldschool;
    private String premodern;
    private String predh;
}
