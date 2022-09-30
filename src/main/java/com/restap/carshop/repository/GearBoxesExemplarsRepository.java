package com.restap.carshop.repository;

import com.restap.carshop.domain.GearBoxExemplar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GearBoxesExemplarsRepository extends CrudRepository<GearBoxExemplar, Long> {

    @Override
    List<GearBoxExemplar> findAll();

    Optional<GearBoxExemplar> findBySerialNumber(String serialNumber);

    Optional<GearBoxExemplar> findByAvailable(boolean available);
}
