package com.restap.carshop.repository;

import com.restap.carshop.domain.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface SeatRepository extends CrudRepository<Seat, Long> {

    List<Seat> findAll();

    Optional<Seat> findByType(String type);
}
