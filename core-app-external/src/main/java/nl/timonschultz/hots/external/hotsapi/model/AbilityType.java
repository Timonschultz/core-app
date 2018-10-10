package nl.timonschultz.hots.external.hotsapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbilityType {

    private String owner;
    private String name;
    private String title;
    private String description;
    private String icon;
    private String hotkey;
    private int cooldown;
    private int manaCost;
    private boolean trait;

}