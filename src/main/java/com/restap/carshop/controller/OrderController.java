package com.restap.carshop.controller;

import com.restap.carshop.domain.Car;
import com.restap.carshop.domain.Order;
import com.restap.carshop.dto.OrderDto;
import com.restap.carshop.exception.CarException;
import com.restap.carshop.exception.OrderException;
import com.restap.carshop.exception.UserException;
import com.restap.carshop.mapper.CarMapper;
import com.restap.carshop.mapper.OrderMapper;
import com.restap.carshop.service.CarService;
import com.restap.carshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;
    private final OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody final OrderDto orderDto) throws UserException {
        Order order = orderMapper.mapToOrder(orderDto);
        orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam final Long id) throws OrderException {
        return orderMapper.mapToOrderDto(orderService.findOrderById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(final Long id) throws OrderException {
        orderService.deleteOrder(id);
    }
}
