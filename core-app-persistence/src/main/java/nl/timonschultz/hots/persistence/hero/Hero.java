package nl.timonschultz.hots.persistence.hero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.timonschultz.hots.persistence.ability.Ability;
import nl.timonschultz.hots.persistence.common.HasId;
import nl.timonschultz.hots.persistence.icon.Icon;
import nl.timonschultz.hots.persistence.talent.Talent;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "HEROES")
public class Hero extends HasId<Long> {

    @Column(name = "HERO_NAME")
    private String name;

    @Column(name = "HERO_SHORT_NAME")
    private String shortName;

    //TODO: Attribute id? Waar is deze goed voor en kan het niet beter anders?
    @Column(name = "HERO_ATTRIBUTE_ID")
    private String attributeId;

    @Column(name = "HERO_TRANSLATIONS")
    @ElementCollection
    private List<String> translations;

    @Column(name = "HERO_ROLE")
    private String role;

    @Column(name = "HERO_TYPE")
    private String type;

    @Column(name = "HERO_RELEASE_DATE")
    private LocalDate releaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Icon icon;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ability> abilities;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Talent> talents;

}