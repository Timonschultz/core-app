package nl.timonschultz.hots.external.hotsapi.client;

import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.model.AbilityType;
import nl.timonschultz.hots.external.hotsapi.model.HeroType;
import nl.timonschultz.hots.external.hotsapi.model.MapType;
import nl.timonschultz.hots.external.hotsapi.model.TalentType;

import java.util.List;

public interface HeroClient {

    List<HeroType> getHeroesFromAPI() throws ClientException;

    HeroType getHeroeFromAPI(String heroName) throws ClientException;

    AbilityType getHeroAbilityFromApi(String heroName, String abilityName) throws ClientException;

    TalentType getTalentFromApi(String talentName) throws ClientException;



}
