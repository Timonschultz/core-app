package nl.timonschultz.hots.external.hotsapi;

import nl.timonschultz.hots.external.hotsapi.client.HeroClient;
import nl.timonschultz.hots.external.hotsapi.client.HeroClientImpl;
import org.junit.Test;

public class HeroClientImplTest {

    private HeroClient heroClient = new HeroClientImpl();

    @Test
    public void getHeroesFromAPI() {
        heroClient.getHeroesFromAPI();

    }
}