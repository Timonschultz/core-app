package nl.timonschultz.hots.controller;

import nl.timonschultz.hots.core.hero.HeroService;
import nl.timonschultz.hots.core.icon.IconService;
import nl.timonschultz.hots.core.map.MapService;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/import")
public class ImportController {

    private HeroService heroService;
    private IconService iconService;
    private MapService mapService;

    @Autowired
    public ImportController(HeroService heroService, IconService iconService, MapService mapService) {
        this.heroService = heroService;
        this.iconService = iconService;
        this.mapService = mapService;
    }

    @GetMapping("/heroes/all")
    public String importHeroes() throws ClientException {
        int imports = heroService.importHeroes();
        return imports + " Heroes imported into the database";
    }

    @GetMapping("/icons/all")
    public void importIcons() {
        iconService.importAllIconImages();
    }

    @GetMapping("/maps/all")
    public String importMaps() throws ClientException {
        int count = mapService.importMaps();
        return count + " maps imported into the datase";
    }

}