package nl.timonschultz.hots.external.hotsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeroType {

    private String name;
    private String shortName;
    private String attributeId;
    private List<String> translations;
    private String role;
    private String type;
    @JsonProperty("icon_url")
    private IconUrlType heroIcon;
    private String releaseDate;
    private List<AbilityType> abilities;
    private List<TalentType> talents;


}
