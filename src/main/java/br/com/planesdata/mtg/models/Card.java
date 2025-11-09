package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "cards")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {

    @JsonProperty(value = "object")
    private String type;

    @Id
    private String id;

    @JsonProperty(value = "oracle_id")
    private String oracleID;

    @JsonProperty(value = "multiverse_ids")
    private List<Integer> multiverseIDs;

    private String name;

    private String lang;

    @JsonProperty(value = "released_at")
    private String releasedAt;

    private String layout;

    @JsonProperty(value = "highres_image")
    private String highresImage;

    @JsonProperty(value = "image_status")
    private String imageStatus;

    @JsonProperty(value = "image_uris")
    private ImageURI imageURI;

    @JsonProperty(value = "mana_cost")
    private String manaCost;

    private String cmc;

    @JsonProperty(value = "type_line")
    private String typeLine;

    @JsonProperty(value = "oracle_text")
    private String oracleText;

    private String power;

    private String toughness;

    private List<String> colors;

    @JsonProperty(value = "color_indicator")
    private List<String> colorIndicators;

    @JsonProperty(value = "color_identity")
    private List<String> colorIdentities;

    private List<String> keywords;

    @JsonProperty(value = "card_faces")
    private List<CardFace> cardFaces;

    @JsonProperty(value = "all_parts")
    private List<AllPart> allParts;

    @JsonProperty(value = "produced_mana")
    private List<String> producedMana;

    @JsonProperty(value = "legalities")
    private Legality legality;

    private List<String> games;

    private Boolean reserved;

    @JsonProperty(value = "game_changer")
    private Boolean gameChanger;

    private Boolean foil;

    @JsonProperty(value = "nonfoil")
    private Boolean nonFoil;

    private List<String> finishes;

    private Boolean oversized;

    private Boolean promo;

    private Boolean reprint;

    @JsonProperty(value = "printed_name")
    private String printedName;

    @JsonProperty(value = "printed_text")
    private String printedText;

    @JsonProperty(value = "printed_type_line")
    private String printedTypeLine;

    @JsonProperty(value = "promo_types")
    private List<String> promoTypes;

    private String loyalty;

    @JsonProperty(value = "life_modifier")
    private String lifeModifier;

    @JsonProperty(value = "hand_modifier")
    private String handModifier;

    @JsonProperty(value = "attraction_lights")
    private List<String> attractionLights;

    private Boolean variation;

    @JsonProperty(value = "variation_of")
    private String variationOf;

    @JsonProperty(value = "set_id")
    private String setID;

    private String set;

    @JsonProperty(value = "set_name")
    private String setName;

    @JsonProperty(value = "set_type")
    private String setType;

    @JsonProperty(value = "collector_number")
    private String collectorNumber;

    private String rarity;

    @JsonProperty(value = "flavor_text")
    private String flavorText;

    @JsonProperty(value = "card_back_id")
    private String cardbackId;

    private String artist;

    @JsonProperty(value = "artist_ids")
    private List<String> artistIDs;

    @JsonProperty(value = "illustration_id")
    private String illustrationID;

    @JsonProperty(value = "border_color")
    private String borderColor;

    private String frame;

    private String defense;
}
