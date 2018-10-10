package nl.timonschultz.hots.external.hotsapi.mapper;

import nl.timonschultz.hots.external.hotsapi.model.HeroType;
import nl.timonschultz.hots.persistence.hero.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HeroMapper {

    private IconMapper iconMapper;
    private AbilityMapper abilityMapper;
    private TalentMapper talentMapper;

    @Autowired
    public HeroMapper(IconMapper iconMapper, AbilityMapper abilityMapper, TalentMapper talentMapper) {
        this.iconMapper = iconMapper;
        this.abilityMapper = abilityMapper;
        this.talentMapper = talentMapper;
    }

    public Hero mapToHero(HeroType heroType) {
        return Hero.builder().name(heroType.getName())
                .shortName(heroType.getShortName())
                .attributeId(heroType.getAttributeId())
                .translations(heroType.getTranslations())
                .role(heroType.getRole())
                .type(heroType.getType())
                .releaseDate(LocalDate.parse(heroType.getReleaseDate()))
                .icon(iconMapper.mapToIcon(heroType.getHeroIcon()))
                .abilities(abilityMapper.mapToAbilityList(heroType.getAbilities()))
                .talents(talentMapper.mapToTalentList(heroType.getTalents()))
                .build();
    }

}