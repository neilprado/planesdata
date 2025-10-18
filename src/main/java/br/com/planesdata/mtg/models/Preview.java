package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Preview {

    private String source;

    @JsonProperty(value = "source_uri")
    private String sourceUri;

    @JsonProperty(value = "previewed_at")
    private String previewedAt;
}
