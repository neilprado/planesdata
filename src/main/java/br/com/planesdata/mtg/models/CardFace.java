package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CardFace {

    @JsonProperty(value = "object")
    private String type;

    private String name;

    @JsonProperty(value = "oracle_id")
    private String oracleID;

    @JsonProperty(value = "mana_cost")
    private String manaCost;

    @JsonProperty(value = "type_line")
    private String typeLine;

    @JsonProperty(value = "oracle_text")
    private String oracleText;

    private List<String> colors;

    private Integer defense;

    private String layout;

    private String cmc;

    @JsonProperty(value = "flavor_name")
    private String flavorName;

    @JsonProperty(value = "flavor_text")
    private String flavorText;

    @JsonProperty(value = "printed_name")
    private String printedName;

    @JsonProperty(value = "printed_type_line")
    private String printedTypeLine;

    @JsonProperty(value = "printed_text")
    private String printedText;

    private String watermark;

    private Integer loyalty;

    @JsonProperty(value = "color_indicator")
    private List<String> colorIndicator;

    private String power;

    private String toughness;

    private String artist;

    @JsonProperty(value = "artist_id")
    private String artistID;

    @JsonProperty(value = "illustration_id")
    private String illustrationID;

    @JsonProperty(value = "image_uris")
    private ImageURI imageURI;
}
