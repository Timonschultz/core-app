package nl.timonschultz.hots.external.hotsapi;

import nl.timonschultz.hots.external.hotsapi.client.HeroClient;
import nl.timonschultz.hots.external.hotsapi.client.HotsApiHeroesClient;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import org.junit.Test;

public class HotsApiHeroesClientTest {

    private HeroClient heroClient = new HotsApiHeroesClient();

    @Test
    public void getHeroesFromAPI() throws ClientException {
        heroClient.getHeroesFromAPI();

    }
}