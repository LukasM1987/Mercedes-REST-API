package com.restap.carshop.service;

import com.restap.carshop.domain.Color;
import com.restap.carshop.exception.ColorException;
import com.restap.carshop.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepository colorRepository;

    public Color addColor(final Color color) {
        return colorRepository.save(color);
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Color getColorById(final Long id) throws ColorException {
        return colorRepository.findById(id).orElseThrow(ColorException::new);
    }

    public Color getColorByName(final String name) throws ColorException {
        return colorRepository.findByColorName(name).orElseThrow(ColorException::new);
    }

    public void deleteColor(final Long id) throws ColorException {
        if (colorRepository.findById(id).isPresent()) {
            colorRepository.deleteById(id);
        } else {
            throw new ColorException();
        }
    }
}
