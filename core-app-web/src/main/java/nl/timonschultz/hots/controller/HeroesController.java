package nl.timonschultz.hots.controller;

import nl.timonschultz.hots.core.hero.HeroService;
import nl.timonschultz.hots.persistence.hero.Hero;
import nl.timonschultz.hots.persistence.hero.HeroNameAndIdAndShortName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/heroes")
public class HeroesController {

    private HeroService heroService;

    @Autowired
    public HeroesController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/all")
    public List<HeroNameAndIdAndShortName> getHeroNames() {
        return heroService.getHeroNames();
    }

    @GetMapping("/id/{id}")
    public Hero getHero(@PathVariable("id") Long id) {
        return heroService.getHero(id);
    }

    @GetMapping("/shortName/{shortName}")
    public Hero getHero(@PathVariable("shortName") String shortName) {
        return heroService.getHero(shortName);
    }

}