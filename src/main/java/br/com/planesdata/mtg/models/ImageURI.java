package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ImageURI {

    private String small;
    private String normal;
    private String large;
    private String png;

    @JsonProperty(value = "art_crop")
    private String artCrop;

    @JsonProperty(value = "border_crop")
    private String borderCrop;
}
