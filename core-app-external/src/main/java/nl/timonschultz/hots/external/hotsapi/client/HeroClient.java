package nl.timonschultz.hots.external.hotsapi.client;

import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.model.HeroType;
import nl.timonschultz.hots.external.hotsapi.model.MapType;

import java.util.List;

public interface HeroClient {

    List<HeroType> getHeroesFromAPI() throws ClientException;

    List<MapType> getMapsFromApi() throws ClientException;

}
