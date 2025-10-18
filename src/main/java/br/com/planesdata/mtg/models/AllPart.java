package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AllPart {

    @JsonProperty(value = "object")
    private String type;

    private String id;

    private String component;

    private String name;

    @JsonProperty(value = "type_line")
    private String typeLine;

    private String uri;
}