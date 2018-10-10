package nl.timonschultz.hots.external.hotsapi.mapper;

import nl.timonschultz.hots.external.hotsapi.model.TalentType;
import nl.timonschultz.hots.persistence.talent.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TalentMapper {

    private IconMapper iconMapper;

    @Autowired
    public TalentMapper(IconMapper iconMapper) {
        this.iconMapper = iconMapper;
    }

    public Talent mapToTalent(TalentType talentType) {
        return Talent.builder().name(talentType.getName())
                .title(talentType.getTitle())
                .description(talentType.getDescription())
                .iconFileName(talentType.getIconFileName())
                .icon(iconMapper.mapToIcon(talentType.getTalentIcon()))
                .ability(talentType.getAbility())
                .sort(talentType.getSort())
                .cooldown(talentType.getCooldown())
                .manaCost(talentType.getManaCost())
                .level(talentType.getLevel())
                .build();
    }

    public List<Talent> mapToTalentList(List<TalentType> talentTypeList) {
        List<Talent> talents = new ArrayList<>();
        talentTypeList.forEach(talentType -> talents.add(mapToTalent(talentType)));
        return talents;
    }

}