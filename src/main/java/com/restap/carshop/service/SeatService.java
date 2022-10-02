package com.restap.carshop.service;

import com.restap.carshop.domain.Seat;
import com.restap.carshop.exception.SeatException;
import com.restap.carshop.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Seat getSeatById(final Long id) throws SeatException {
        return seatRepository.findById(id).orElseThrow(SeatException::new);
    }

    public Seat getSeatByType(final String type) throws SeatException {
        return seatRepository.findByType(type).orElseThrow(SeatException::new);
    }

    public void deleteSeat(final Long id) {
        seatRepository.deleteById(id);
    }
}
