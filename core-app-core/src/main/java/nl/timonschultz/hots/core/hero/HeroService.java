package nl.timonschultz.hots.core.hero;

import lombok.extern.slf4j.Slf4j;
import nl.timonschultz.hots.external.hotsapi.client.HeroClient;
import nl.timonschultz.hots.external.hotsapi.client.HotsApiHeroesClient;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.mapper.HeroMapper;
import nl.timonschultz.hots.external.hotsapi.model.HeroType;
import nl.timonschultz.hots.persistence.hero.Hero;
import nl.timonschultz.hots.persistence.hero.HeroNameAndIdAndShortName;
import nl.timonschultz.hots.persistence.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
public class HeroService {

    private HeroMapper heroMapper;
    private HeroClient heroClient;
    private HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroMapper heroMapper, HotsApiHeroesClient heroClient, HeroRepository heroRepository) {
        this.heroMapper = heroMapper;
        this.heroClient = heroClient;
        this.heroRepository = heroRepository;
    }

    public Hero getHero(final Long id) {
        return heroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No hero with id " + id + " found in the database."));
    }

    public Hero getHero(String shortName) {
        return heroRepository.findByShortName(shortName).orElseThrow(() -> new EntityNotFoundException("No hero with name '" + shortName + "' present in database"));
    }

    public List<HeroNameAndIdAndShortName> getHeroNames() {
        return heroRepository.getIdAndName();
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
        log.info("Imported number of heroes: {}", count);
        return count;
    }


}
