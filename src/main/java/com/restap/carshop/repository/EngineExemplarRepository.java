package com.restap.carshop.repository;

import com.restap.carshop.domain.EngineExemplar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EngineExemplarRepository extends CrudRepository<EngineExemplar, Long> {

    @Override
    List<EngineExemplar> findAll();

    Optional<EngineExemplar> findBySerialNumber(String serialNumber);

    Optional<EngineExemplar> findByAvailable(boolean available);
}
