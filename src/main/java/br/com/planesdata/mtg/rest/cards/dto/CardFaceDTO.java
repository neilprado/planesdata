package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.CardFace;

import java.util.List;

public record CardFaceDTO(
        String type,
        String name,
        String oracleID,
        String manaCost,
        String typeLine,
        String oracleText,
        List<String> colors,
        Integer defense,
        String layout,
        String cmc,
        String flavorName,
        String flavorText,
        String printedName,
        String printedTypeLine,
        String printedText,
        String watermark,
        Integer loyalty,
        List<String> colorIndicator,
        String power,
        String toughness,
        String artist,
        String artistID,
        String illustrationID,
        ImageUriDTO imageURI) {

    public static CardFaceDTO toDto(CardFace cardFace) {
        ImageUriDTO imageUri = ImageUriDTO.toDto(cardFace.getImageURI());

        return new CardFaceDTO(
                        cardFace.getType(),
                        cardFace.getName(),
                        cardFace.getOracleID(),
                        cardFace.getManaCost(),
                        cardFace.getTypeLine(),
                        cardFace.getOracleText(),
                        cardFace.getColors(),
                        cardFace.getDefense(),
                        cardFace.getLayout(),
                        cardFace.getCmc(),
                        cardFace.getFlavorName(),
                        cardFace.getFlavorText(),
                        cardFace.getPrintedName(),
                        cardFace.getPrintedTypeLine(),
                        cardFace.getPrintedText(),
                        cardFace.getWatermark(),
                        cardFace.getLoyalty(),
                        cardFace.getColorIndicator(),
                        cardFace.getPower(),
                        cardFace.getToughness(),
                        cardFace.getArtist(),
                        cardFace.getArtistID(),
                        cardFace.getIllustrationID(),
                        imageUri);
    }
}
