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

    @JsonProperty("short_name")
    private String shortName;

    @JsonProperty("attribute_id")
    private String attributeId;
    private List<String> translations;
    private String role;
    private String type;

    @JsonProperty("icon_url")
    private IconUrlType heroIcon;

    @JsonProperty("release_date")
    private String releaseDate;
    private List<AbilityType> abilities;
    private List<TalentType> talents;


}
