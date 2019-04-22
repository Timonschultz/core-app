package nl.timonschultz.hots.core.icon;

import lombok.extern.slf4j.Slf4j;
import nl.timonschultz.hots.persistence.icon.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class IconService {

    private IconRepository iconRepository;
    private RestTemplate restTemplate;

    @Autowired
    public IconService(IconRepository iconRepository) {
        this.iconRepository = iconRepository;
        this.restTemplate = new RestTemplate();
    }

    public void importAllIconImages() {
        long max = iconRepository.count();
        for (int i = 1; i < max; i++) {
            if (iconRepository.existsByIconIsNullAndId(i)) {
                System.out.println(i);
                try {
                    saveIconImageFromUrl(i);
                } catch (HttpClientErrorException e) {
                    log.error("Error getting Image for Icon with id " + i + ": " + e.getMessage());
                }
            }
        }
    }

    private void saveIconImageFromUrl(int id) {
        iconRepository.findById(Long.valueOf(id)).ifPresent(icon -> {
            byte[] imageBytes = restTemplate.getForObject(icon.getIconUrl(), byte[].class);
            icon.setIconImage(imageBytes);
            iconRepository.save(icon);
        });
    }

}
