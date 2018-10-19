package nl.timonschultz.hots.external.hotsapi.client;

import lombok.extern.slf4j.Slf4j;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.model.AbilityType;
import nl.timonschultz.hots.external.hotsapi.model.HeroType;
import nl.timonschultz.hots.external.hotsapi.model.TalentType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class HotsApiHeroesClient implements HeroClient {

    private static final String HEROES_IMPORT_URL = "http://hotsapi.net/api/v1/heroes";
    private static final String TALENTS_IMPORT_URL = "http://hotsapi.net/api/v1/talents";
    static final String REST_CLIENT_EXCEPTION_OCCURED = "RestClientException occured: ";

    private RestTemplate restTemplate;

    public HotsApiHeroesClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<HeroType> getHeroesFromAPI() throws ClientException {
        try {
            return restTemplate.exchange(HEROES_IMPORT_URL, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<HeroType>>() {
                    }).getBody();
        } catch (RestClientException e) {
            log.error(REST_CLIENT_EXCEPTION_OCCURED + e.getMessage());
            throw new ClientException(e);
        }
    }

    @Override
    public HeroType getHeroeFromAPI(String heroName) throws ClientException {
        try {
            String url = HEROES_IMPORT_URL + "/" + heroName;
            return restTemplate.exchange(url, HttpMethod.GET, null, HeroType.class).getBody();
        } catch (RestClientException e) {
            log.error(REST_CLIENT_EXCEPTION_OCCURED + e.getMessage());
            throw new ClientException(e);
        }
    }

    @Override
    public AbilityType getHeroAbilityFromApi(String heroName, String abilityName) throws ClientException {
        try {
            String url = HEROES_IMPORT_URL + "/" + heroName + "/" + abilityName;
            return restTemplate.exchange(url, HttpMethod.GET, null, AbilityType.class).getBody();
        } catch (RestClientException e) {
            log.error(REST_CLIENT_EXCEPTION_OCCURED + e.getMessage());
            throw new ClientException(e);
        }
    }

    @Override
    public TalentType getTalentFromApi(String talentName) throws ClientException {
        try {
            String url = TALENTS_IMPORT_URL + "/" + talentName;
            return restTemplate.exchange(url, HttpMethod.GET, null, TalentType.class).getBody();
        } catch (RestClientException e) {
            log.error(REST_CLIENT_EXCEPTION_OCCURED + e.getMessage());
            throw new ClientException(e);
        }
    }
}