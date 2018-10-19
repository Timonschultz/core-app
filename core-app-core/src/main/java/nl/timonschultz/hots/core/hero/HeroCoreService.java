package nl.timonschultz.hots.core.hero;

import nl.timonschultz.hots.persistence.hero.Hero;
import nl.timonschultz.hots.persistence.hero.HeroRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class HeroCoreService {

    private HeroRepository heroRepository;

    public HeroCoreService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero getHerobyId(final Long id) {
        return heroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No hero with id " + id + " found in the database."));
    }
    
}