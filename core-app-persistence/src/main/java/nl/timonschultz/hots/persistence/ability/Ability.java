package nl.timonschultz.hots.persistence.ability;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.timonschultz.hots.persistence.common.HasId;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ABILITIES")
public class Ability extends HasId<Long> {

    @Column(name = "ABILITY_OWNER")
    private String owner;

    //TODO: relatie met TALENT_ABILITY column?
    @Column(name = "ABILITY_NAME")
    private String name;

    @Column(name = "ABILITY_TITLE")
    private String title;

    @Column(name = "ABILITY_DESCRIPTION")
    private String description;

    @Column(name = "ABILITY_ICON")
    private String icon;

    @Column(name = "ABILITY_HOTKEY")
    private String hotkey;

    @Column(name = "ABILITY_COOLDOWN")
    private int cooldown;

    @Column(name = "ABILITY_MANACOST")
    private int manaCost;

    @Column(name = "IS_TRAIT")
    private boolean trait;

}