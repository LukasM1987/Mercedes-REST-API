package com.restap.carshop.repository;

import com.restap.carshop.domain.Drive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DriveRepository extends CrudRepository<Drive, Long> {

    @Override
    List<Drive> findAll();

    @Override
    Optional<Drive> findById(Long id);

    Optional<Drive> findByType(String type);
}
