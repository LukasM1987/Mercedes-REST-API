package com.restap.carshop.repository;

import com.restap.carshop.domain.ModelExemplar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ModelExemplarRepository extends CrudRepository<ModelExemplar, Long> {

    @Override
    List<ModelExemplar> findAll();

    Optional<ModelExemplar> findByVin(String vin);

    Optional<ModelExemplar> findByAvailable(boolean available);
}
