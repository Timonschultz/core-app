package nl.timonschultz.hots.persistence.talent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.timonschultz.hots.persistence.common.HasId;
import nl.timonschultz.hots.persistence.icon.Icon;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TALENTS")
public class Talent extends HasId<Long> {


    @Column(name = "TALENT_NAME")
    private String name;

    @Column(name = "TALENT_TITLE")
    private String title;

    @Column(name = "TALENT_DESCRIPTION")
    private String description;

    @Column(name = "TALENT_ICON_FILE_NAME")
    private String iconFileName;

    @Column(name = "TALENT_ICON")
    @OneToOne(cascade = CascadeType.ALL)
    private Icon icon;

    //TODO: relatie met ABILITY_NAME column?
    @Column(name = "TALENT_ABILITY")
    private String ability;

    @Column(name = "TALENT_SORT")
    private int sort;

    @Column(name = "TALENT_COOLDOWN")
    private int cooldown;

    @Column(name = "TALENT_MANACOST")
    private int manaCost;

    @Column(name = "TALENT_LEVEL")
    private int level;

}