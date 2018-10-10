package nl.timonschultz.hots.external.hotsapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MapType {

    private String name;
    private List<String> translations;

}