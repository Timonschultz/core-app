package nl.timonschultz.hots.persistence.map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.timonschultz.hots.persistence.common.HasId;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MAPS")
public class Map extends HasId<Long> {

    @Column(name = "MAP_NAME")
    private String name;

    @ElementCollection
    @Column(name = "MAP_NAME_TRANSLATIONS")
    private List<String> translations;

}