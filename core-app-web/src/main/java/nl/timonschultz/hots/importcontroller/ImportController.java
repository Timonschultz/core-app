package nl.timonschultz.hots.importcontroller;

import nl.timonschultz.hots.core.icon.IconService;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.service.HeroApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/import")
public class ImportController {

    private HeroApi heroService;
    private IconService iconService;

    @Autowired
    public ImportController(HeroApi heroService, IconService iconService) {
        this.heroService = heroService;
        this.iconService = iconService;
    }

    @GetMapping(value = "/heroes/all")
    public String importHeroes() throws ClientException {
        int imports = heroService.importHeroes();
        return imports + " Heroes imported into the database";
    }

    @GetMapping(value = "/icons/all")
    public void importIcons() {
        iconService.importAllIconImages();
    }


}
