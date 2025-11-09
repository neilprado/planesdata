package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.Legality;

public record LegalityDTO(
        String standard,
        String future,
        String historic,
        String pioneer,
        String modern,
        String legacy,
        String pauper,
        String vintage,
        String penny,
        String commander,
        String oathbreaker,
        String paupercommander,
        String oldschool,
        String premodern,
        String predh) {

    public static LegalityDTO toDto(Legality model) {
        return new LegalityDTO(
                model.getStandard(),
                model.getFuture(),
                model.getHistoric(),
                model.getPioneer(),
                model.getModern(),
                model.getLegacy(),
                model.getPauper(),
                model.getVintage(),
                model.getPenny(),
                model.getCommander(),
                model.getOathbreaker(),
                model.getPaupercommander(),
                model.getOldschool(),
                model.getPremodern(),
                model.getPredh());
    }
}
