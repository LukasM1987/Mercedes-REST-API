package com.restap.carshop.repository;

import com.restap.carshop.domain.GearBox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GearBoxRepository extends CrudRepository<GearBox, Long> {

    @Override
    List<GearBox> findAll();

    @Override
    Optional<GearBox> findById(Long id);

}
