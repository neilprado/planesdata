package br.com.planesdata.mtg.rest.rulings.dto;

import br.com.planesdata.mtg.models.Ruling;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record RulingResponseDTO(
        String type,
        Boolean hasMore,
        String oracleID,
        String source,
        String publishedAt,
        String comment,
        List<RulingDataDTO> rulingData) {

    public static RulingResponseDTO toDto(Ruling model) {
        List<RulingDataDTO> rulingsData = Objects.nonNull(model.getRulingData()) ?
                model.getRulingData().stream().map(RulingDataDTO::toDto).toList() :
                null;
        
        return new RulingResponseDTO(
                model.getType(),
                model.getHasMore(),
                model.getOracleID(),
                model.getSource(),
                model.getPublishedAt(),
                model.getComment(),
                rulingsData);
    }
}
