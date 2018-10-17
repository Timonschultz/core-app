package nl.timonschultz.hots.service;

import nl.timonschultz.hots.external.hotsapi.client.HeroClient;
import nl.timonschultz.hots.external.hotsapi.client.HeroClientImpl;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.mapper.HeroMapper;
import nl.timonschultz.hots.external.hotsapi.model.HeroType;
import nl.timonschultz.hots.persistence.hero.Hero;
import nl.timonschultz.hots.persistence.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroApi {

    private HeroMapper heroMapper;
    private HeroClient heroClient;
    private HeroRepository heroRepository;

    @Autowired
    public HeroApi(HeroMapper heroMapper, HeroClientImpl heroClient, HeroRepository heroRepository) {
        this.heroMapper = heroMapper;
        this.heroClient = heroClient;
        this.heroRepository = heroRepository;
    }

    public int importHeroes() throws ClientException {
        int count = 0;
        List<HeroType> heroes = heroClient.getHeroesFromAPI();
        for (HeroType hero : heroes) {
            System.out.print(hero.getName());
            if (!heroRepository.existsByName(hero.getName())) {
                Hero h = heroRepository.save(heroMapper.mapToHero(hero));
                System.out.print(" imported. ID = " + h.getId() + "\n");
                count++;
            }
        }
        return count;
    }

}