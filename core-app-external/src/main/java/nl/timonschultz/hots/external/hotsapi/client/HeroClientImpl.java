package nl.timonschultz.hots.external.hotsapi.client;

import lombok.extern.slf4j.Slf4j;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.model.HeroType;
import nl.timonschultz.hots.external.hotsapi.model.MapType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class HeroClientImpl implements HeroClient {

    private static final String HEROES_IMPORT_URL = "http://hotsapi.net/api/v1/heroes";

    private RestTemplate restTemplate;

    public HeroClientImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<HeroType> getHeroesFromAPI() throws ClientException {
        try {
            return restTemplate.exchange(HEROES_IMPORT_URL, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<HeroType>>() {
                    }).getBody();
        } catch (RestClientException e) {
            log.error("RestClientException occured: " + e.getMessage());
            throw new ClientException(e);
        }
    }

    @Override
    public List<MapType> getMapsFromApi() throws ClientException {
        ResponseEntity<List<MapType>> response = restTemplate.exchange(HEROES_IMPORT_URL,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<MapType>>() {
                });
        return null;
    }

}