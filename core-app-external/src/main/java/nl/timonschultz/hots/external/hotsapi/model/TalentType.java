package nl.timonschultz.hots.external.hotsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TalentType {

    private String name;
    private String title;
    private String description;

    @JsonProperty("icon")
    private String iconFileName;

    @JsonProperty("icon_url")
    private IconUrlType talentIcon;
    private String ability;
    private int sort;
    private int cooldown;

    @JsonProperty("mana_cost")
    private int manaCost;
    private int level;

}