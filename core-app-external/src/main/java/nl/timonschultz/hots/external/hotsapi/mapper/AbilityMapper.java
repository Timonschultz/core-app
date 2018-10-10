package nl.timonschultz.hots.external.hotsapi.mapper;

import nl.timonschultz.hots.external.hotsapi.model.AbilityType;
import nl.timonschultz.hots.persistence.ability.Ability;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AbilityMapper {

    public Ability mapToAbility(AbilityType abilityType) {
        return Ability.builder().owner(abilityType.getOwner())
                .name(abilityType.getName())
                .title(abilityType.getTitle())
                .description(abilityType.getDescription())
                .icon(abilityType.getIcon())
                .hotkey(abilityType.getHotkey())
                .cooldown(abilityType.getCooldown())
                .manaCost(abilityType.getManaCost())
                .trait(abilityType.isTrait())
                .build();
    }

    public List<Ability> mapToAbilityList(List<AbilityType> abilityTypeList) {
        List<Ability> abilities = new ArrayList<>();
        abilityTypeList.forEach(abilityType -> abilities.add(mapToAbility(abilityType)));
        return abilities;
    }

}