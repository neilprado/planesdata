package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RulingData {

    @JsonProperty(value = "object")
    private String type;

    @JsonProperty(value = "oracle_id")
    private String oracleID;

    private String source;

    @JsonProperty(value = "published_at")
    private String publishedAt;

    private String comment;
}
