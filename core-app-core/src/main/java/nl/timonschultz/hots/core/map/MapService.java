package nl.timonschultz.hots.core.map;

import nl.timonschultz.hots.external.hotsapi.client.HotsApiMapClient;
import nl.timonschultz.hots.external.hotsapi.client.MapClient;
import nl.timonschultz.hots.external.hotsapi.exception.ClientException;
import nl.timonschultz.hots.external.hotsapi.mapper.MapMapper;
import nl.timonschultz.hots.external.hotsapi.model.MapType;
import nl.timonschultz.hots.persistence.map.Map;
import nl.timonschultz.hots.persistence.map.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MapService {

    private MapClient mapClient;
    private MapMapper mapMapper;
    private MapRepository mapRepository;

    @Autowired
    public MapService(HotsApiMapClient mapClient, MapMapper mapMapper, MapRepository mapRepository) {
        this.mapClient = mapClient;
        this.mapMapper = mapMapper;
        this.mapRepository = mapRepository;
    }

    public List<Map> getMaps() {
        return mapRepository.findAll();
    }

    public Map getMap(String name) {
        return mapRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("No map with name '" + name + "' found in database"));
    }

    public Map getMap(Long id) {
        return mapRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No map with id '" + id + "' found in database"));
    }


    public int importMaps() throws ClientException {
        int count = 0;
        List<MapType> maps = mapClient.getMapsFromApi();
        for (MapType map : maps) {
            System.out.print(map.getName());
            if (!mapRepository.existsByName(map.getName())) {
                Map m = mapRepository.save(mapMapper.mapToMap(map));
                System.out.print(" imported id: " + m.getId() + "\n");
                count++;
            }
        }
        return count;
    }

}