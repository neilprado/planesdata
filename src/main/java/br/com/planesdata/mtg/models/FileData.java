package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileData {

    @JsonProperty(value = "object")
    private String bulk;

    private String id;

    private String type;

    @JsonProperty(value = "updated_at")
    private String updatedAt;

    private String uri;

    private String name;

    private String description;

    private Long size;

    @JsonProperty(value = "download_uri")
    private String downloadUri;

    @JsonProperty(value = "content_type")
    private String contentType;

    @JsonProperty(value = "content_encoding")
    private String contentEncoding;
}
