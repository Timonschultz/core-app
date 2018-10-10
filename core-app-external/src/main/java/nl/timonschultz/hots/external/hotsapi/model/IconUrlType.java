package nl.timonschultz.hots.external.hotsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IconUrlType {

    @JsonProperty("92x93")
    private String heroIconUrl;

    @JsonProperty("64x64")
    private String talentIconUrl;

    public String getIconUrl() {
        return (heroIconUrl != null) ? heroIconUrl : talentIconUrl;
    }

}