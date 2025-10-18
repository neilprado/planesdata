package br.com.planesdata.mtg.models;

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
public class Card {

    @JsonProperty(value = "object")
    private String type;

    @Id
    private String id;

    @JsonProperty(value = "oracle_id")
    private String oracleID;

    @JsonProperty(value = "multiverse_ids")
    private List<Integer> multiverseIDs;

    @JsonProperty(value = "mtgo_id")
    private Integer mtgoID;

    @JsonProperty(value = "arena_id")
    private Integer arenaId;

    @JsonProperty(value = "mtgo_foil_id")
    private Integer mtgoFoilID;

    @JsonProperty(value = "tcgplayer_id")
    private Integer tcgPlayerID;

    @JsonProperty(value = "cardmarket_id")
    private Integer cardMarketID;

    private String name;

    private String lang;

    @JsonProperty(value = "released_at")
    private String releasedAt;

    private String uri;

    @JsonProperty(value = "scryfall_uri")
    private String scryfallURI;

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

    @JsonProperty(value = "set_uri")
    private String setUri;

    @JsonProperty(value = "set_search_uri")
    private String setSearchUri;

    @JsonProperty(value = "scryfall_set_uri")
    private String scryfallSetUri;

    @JsonProperty(value = "rulings_uri")
    private String rulingsUri;

    @JsonProperty(value = "prints_search_uri")
    private String printsSearchUri;

    @JsonProperty(value = "collector_number")
    private String collectorNumber;

    private Boolean digital;

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

    @JsonProperty(value = "tcgplayer_etched_id")
    private Integer tcgplayerEtchedID;

    @JsonProperty(value = "frame_effects")
    private List<String> frameEffects;

    @JsonProperty(value = "flavor_name")
    private String flavorName;

    @JsonProperty(value = "content_warning")
    private String contentWarning;

    @JsonProperty(value = "security_stamp")
    private String securityStamp;

    @JsonProperty(value = "full_art")
    private Boolean fullArt;

    private Boolean textless;

    private Boolean booster;

    @JsonProperty(value = "story_spotlight")
    private String storySpotlight;

    @JsonProperty(value = "edhrec_rank")
    private Integer edhrecRank;

    private Preview preview;

    private String watermark;

    @JsonProperty(value = "penny_rank")
    private Integer pennyRank;

    @JsonProperty(value = "prices")
    private Price price;

    @JsonProperty(value = "related_uris")
    private RelatedUri relatedUri;

    @JsonProperty(value = "purchase_uris")
    private PurchaseUri purchaseUri;
}
