package nl.timonschultz.hots.external.hotsapi.mapper;

import nl.timonschultz.hots.external.hotsapi.model.IconUrlType;
import nl.timonschultz.hots.persistence.icon.Icon;
import org.springframework.stereotype.Component;

@Component
public class IconMapper {

    private static final String HERO_ICON_SIZE = "92x93";
    private static final String TALENT_ICON_SIZE = "64x64";

    public Icon mapToIcon(IconUrlType iconUrlType) {
        Icon icon = new Icon();
        icon.setIconUrl(iconUrlType.getIconUrl());
        icon.setSize(getSize(iconUrlType));
        return icon;
    }

    private String getSize(IconUrlType iconUrlType) {
        if (iconUrlType.getHeroIconUrl() != null) {
            return HERO_ICON_SIZE;
        } else if (iconUrlType.getTalentIconUrl() != null) {
            return TALENT_ICON_SIZE;
        } else {
            return null;
        }
    }

}