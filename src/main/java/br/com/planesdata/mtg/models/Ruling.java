package br.com.planesdata.mtg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "rulings")
public class Ruling {

    @JsonProperty(value = "object")
    private String type;

    @JsonProperty(value = "has_more")
    private Boolean hasMore;

    @JsonProperty(value = "oracle_id")
    private String oracleID;

    private String source;

    @JsonProperty(value = "published_at")
    private String publishedAt;

    private String comment;
}
