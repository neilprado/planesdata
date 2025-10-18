package br.com.planesdata.mtg.rest.cards.dto;

import br.com.planesdata.mtg.models.Legality;

public record LegalityDTO(
        String standard,
        String future,
        String historic,
        String timeless,
        String gladiator,
        String pioneer,
        String explorer,
        String modern,
        String legacy,
        String pauper,
        String vintage,
        String penny,
        String commander,
        String oathbreaker,
        String standardbrawl,
        String brawl,
        String alchemy,
        String paupercommander,
        String duel,
        String oldschool,
        String premodern,
        String predh) {

    public static LegalityDTO toDto(Legality model) {
        return new LegalityDTO(
                model.getStandard(),
                model.getFuture(),
                model.getHistoric(),
                model.getTimeless(),
                model.getGladiator(),
                model.getPioneer(),
                model.getExplorer(),
                model.getModern(),
                model.getLegacy(),
                model.getPauper(),
                model.getVintage(),
                model.getPenny(),
                model.getCommander(),
                model.getOathbreaker(),
                model.getStandardbrawl(),
                model.getBrawl(),
                model.getAlchemy(),
                model.getPaupercommander(),
                model.getDuel(),
                model.getOldschool(),
                model.getPremodern(),
                model.getPredh());
    }
}
