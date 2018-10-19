package nl.timonschultz.hots.controller;

import nl.timonschultz.hots.core.icon.IconCoreService;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/import")
public class ImportController {

    private HeroService heroService;
    private IconCoreService iconCoreService;

    @Autowired
    public ImportController(HeroService heroService, IconCoreService iconCoreService) {
        this.heroService = heroService;
        this.iconCoreService = iconCoreService;
    }

    @GetMapping(value = "/heroes/all")
    public String importHeroes() throws ClientException {
        int imports = heroService.importHeroes();
        return imports + " Heroes imported into the database";
    }

    @GetMapping(value = "/icons/all")
    public void importIcons() {
        iconCoreService.importAllIconImages();
    }

    @GetMapping(value = "/maps/all")
    public void importMaps() {
        iconCoreService.importAllIconImages();
    }


}
