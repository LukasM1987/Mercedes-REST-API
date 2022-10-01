package com.restap.carshop.controller;

import com.restap.carshop.domain.Seat;
import com.restap.carshop.dto.SeatDto;
import com.restap.carshop.exception.SeatException;
import com.restap.carshop.mapper.SeatMapper;
import com.restap.carshop.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatMapper seatMapper;
    private final SeatService seatService;

    @RequestMapping(method = RequestMethod.POST, value = "addSeat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSeat(@RequestBody final SeatDto seatDto) {
        Seat seat = seatMapper.mapToSeat(seatDto);
        seatService.addSeat(seat);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteSeat")
    public void deleteSeat(@RequestParam final Long id) {
        seatService.deleteSeat(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSeats")
    public List<SeatDto> getSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return seatMapper.mapToSeatDtoList(seats);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSeatById")
    public SeatDto getSeat(@RequestParam final Long id) throws SeatException {
        return seatMapper.mapToSeatDto(seatService.getSeatById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getSeatByType")
    public SeatDto getSeatByType(@RequestParam final String type) throws SeatException {
        return seatMapper.mapToSeatDto(seatService.getSeatByType(type));
    }
}
