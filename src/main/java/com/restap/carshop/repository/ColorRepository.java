package com.restap.carshop.repository;

import com.restap.carshop.domain.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ColorRepository extends CrudRepository<Color, Long> {

    @Override
    List<Color> findAll();

    @Override
    Optional<Color> findById(Long id);

    Optional<Color> findByColorName(String color);
}
