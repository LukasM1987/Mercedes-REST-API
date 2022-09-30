package com.restap.carshop.mapper;

import com.restap.carshop.domain.Seat;
import com.restap.carshop.dto.SeatDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatMapper {

    public Seat mapToSeat(final SeatDto seatDto) {
        return new Seat(seatDto.getId(), seatDto.getType(), seatDto.getMaterial(),
                seatDto.getColor(), seatDto.getPrice());
    }

    public SeatDto mapToSeatDto(final Seat seat) {
        return new SeatDto(seat.getId(), seat.getType(), seat.getMaterial(),
                seat.getColor(), seat.getPrice());
    }

    public List<SeatDto> mapToSeatDtoList(final List<Seat> seats) {
        return seats.stream().map(this::mapToSeatDto).collect(Collectors.toList());
    }
}
