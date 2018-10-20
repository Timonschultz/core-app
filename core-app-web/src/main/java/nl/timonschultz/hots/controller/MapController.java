package nl.timonschultz.hots.controller;

import nl.timonschultz.hots.core.map.MapService;
import nl.timonschultz.hots.persistence.map.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/maps")
public class MapController {

    private MapService mapService;

    @Autowired
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/all")
    public List<Map> getMaps() {
        return this.mapService.getMaps();
    }

    @GetMapping("/name/{map}")
    public Map getMap(@PathVariable String map) {
        return this.mapService.getMap(map);
    }

    @GetMapping("/name/{id}")
    public Map getMap(@PathVariable Long id) {
        return this.mapService.getMap(id);
    }


}