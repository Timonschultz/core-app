package nl.timonschultz.hots.persistence.icon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.timonschultz.hots.persistence.common.HasId;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ICONS")
public class Icon extends HasId<Long> {

    @Basic(fetch = FetchType.LAZY)
    private byte[] icon;

    @Column(name = "ICON_URL")
    private String iconUrl;

    @Column(name = "ICON_SIZE")
    private String size;

}