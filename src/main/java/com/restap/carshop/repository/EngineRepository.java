package com.restap.carshop.repository;

import com.restap.carshop.domain.Engine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EngineRepository extends CrudRepository<Engine, Long> {

    @Override
    List<Engine> findAll();

    @Override
    Optional<Engine> findById(Long id);
}
