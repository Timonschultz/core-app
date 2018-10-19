package nl.timonschultz.hots.external.hotsapi.client;

import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.model.MapType;

import java.util.List;

public interface MapClient {

    List<MapType> getMapsFromApi() throws ClientException;

    MapType getMapFromApi(String mapName) throws ClientException;

}
