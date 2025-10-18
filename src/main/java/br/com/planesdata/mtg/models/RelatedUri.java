package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RelatedUri {

    private String gatherer;

    @JsonProperty(value = "tcgplayer_infinite_articles")
    private String tcgPlayerInfiniteArticles;

    @JsonProperty(value = "tcgplayer_infinite_decks")
    private String tcgPlayerInfiniteDecks;

    private String edhrec;
}
