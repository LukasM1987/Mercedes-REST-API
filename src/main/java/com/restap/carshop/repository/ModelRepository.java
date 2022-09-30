package com.restap.carshop.repository;

import com.restap.carshop.domain.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ModelRepository extends CrudRepository<Model, Long> {

    @Override
    List<Model> findAll();

    @Override
    Optional<Model> findById(Long id);

    Optional<Model> findByType(String type);

    Optional<Model> findByCarClass(String carClass);
}
