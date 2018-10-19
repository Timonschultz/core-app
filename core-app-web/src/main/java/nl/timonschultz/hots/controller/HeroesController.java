package nl.timonschultz.hots.controller;

import nl.timonschultz.hots.core.hero.HeroCoreService;
import nl.timonschultz.hots.persistence.hero.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/heroes")
public class HeroesController {

    private HeroCoreService heroCoreService;

    @Autowired
    public HeroesController(HeroCoreService heroCoreService) {
        this.heroCoreService = heroCoreService;
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable("id") Long id) {
        return heroCoreService.getHerobyId(id);
    }

}
