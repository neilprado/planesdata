package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Download {

    @JsonProperty(value = "object")
    private String type;

    @JsonProperty(value = "has_more")
    private Boolean more;

    @JsonProperty(value = "data")
    private List<FileData> data;
}
