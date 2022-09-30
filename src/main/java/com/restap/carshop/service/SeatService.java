package com.restap.carshop.service;

import com.restap.carshop.domain.Seat;
import com.restap.carshop.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(final Long id) {
        return seatRepository.findById(id);
    }

    public Optional<Seat> getSeatByType(final String type) {
        return seatRepository.findByType(type);
    }

    public void deleteSeat(final Long id) {
        seatRepository.deleteById(id);
    }
}
