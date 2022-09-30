package com.restap.carshop.service;

import com.restap.carshop.domain.Color;
import com.restap.carshop.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Color> getColor(final Long id) {
        return colorRepository.findById(id);
    }

    public Optional<Color> getColorByName(final String name) {
        return colorRepository.findByColorName(name);
    }

    public void deleteColor(final Long id) {
        colorRepository.deleteById(id);
    }
}
