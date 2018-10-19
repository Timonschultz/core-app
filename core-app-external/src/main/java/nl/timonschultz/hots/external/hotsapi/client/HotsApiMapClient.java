package nl.timonschultz.hots.external.hotsapi.client;

import lombok.extern.slf4j.Slf4j;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.model.MapType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static nl.timonschultz.hots.external.hotsapi.client.HotsApiHeroesClient.REST_CLIENT_EXCEPTION_OCCURED;

@Slf4j
@Service
public class HotsApiMapClient implements MapClient {

    private static final String MAPS_IMPORT_URL = "http://hotsapi.net/api/v1/maps";

    private RestTemplate restTemplate;

    public HotsApiMapClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<MapType> getMapsFromApi() throws ClientException {
        try {
            return restTemplate.exchange(MAPS_IMPORT_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<MapType>>() {
            }).getBody();
        } catch (RestClientException e) {
            log.error(REST_CLIENT_EXCEPTION_OCCURED + e.getMessage());
            throw new ClientException(e);
        }
    }

    @Override
    public MapType getMapFromApi(String mapName) throws ClientException {
        try {
            String url = MAPS_IMPORT_URL + "/" + mapName;
            return restTemplate.exchange(url, HttpMethod.GET, null, MapType.class).getBody();
        } catch (RestClientException e) {
            log.error(REST_CLIENT_EXCEPTION_OCCURED + e.getMessage());
            throw new ClientException(e);
        }
    }

}