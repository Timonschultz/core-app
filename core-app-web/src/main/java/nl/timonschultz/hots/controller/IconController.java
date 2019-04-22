package nl.timonschultz.hots.controller;

import nl.timonschultz.hots.exception.IconNoImageException;
import nl.timonschultz.hots.persistence.icon.Icon;
import nl.timonschultz.hots.persistence.icon.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/iconImage")
public class IconController {

    private IconRepository iconRepository;

    @Autowired
    public IconController(IconRepository iconRepository) {
        this.iconRepository = iconRepository;
    }

    @GetMapping(value = "/{id}", produces = "image/jpg")
    public byte[] getIcon(@PathVariable("id") Long id) throws IconNoImageException {
        Icon icon = iconRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No iconImage with id " + id));
        if (icon.getIconImage() == null)
            throw new IconNoImageException("Icon with id " + id + " has no image in the database");
        return icon.getIconImage();
    }

}
