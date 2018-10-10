package nl.timonschultz.hots.external.hotsapi.mapper;

import nl.timonschultz.hots.external.hotsapi.model.MapType;
import nl.timonschultz.hots.persistence.map.Map;
import org.springframework.stereotype.Component;

@Component
public class MapMapper {

    public Map mapToMap(MapType mapType) {
        return new Map(mapType.getName(), mapType.getTranslations());
    }

}