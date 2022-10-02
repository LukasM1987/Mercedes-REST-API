package com.restap.carshop.mapper;

import com.restap.carshop.domain.Car;
import com.restap.carshop.domain.Order;
import com.restap.carshop.dto.CarDto;
import com.restap.carshop.dto.OrderDto;

import com.restap.carshop.exception.CarException;
import com.restap.carshop.exception.UserException;
import com.restap.carshop.service.CarService;
import com.restap.carshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderMapper {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    private double totalPrice;

    public Order mapToOrder(final OrderDto orderDto) throws UserException {
        Order order = new Order(orderDto.getId());
        order.setUser(userService.getUserById(orderDto.getUserId()).orElseThrow(UserException::new));
        order.setLocalDateTime(LocalDateTime.now());
        order.setCarList(orderDto.getCarsList());
        /*
        for (Car cars : orderDto.getCarsList()) {
            totalPrice = totalPrice + cars.getCarPrice();
        }
        order.setTotalPrice(totalPrice);
        */
        return order;
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(order.getId(),
                order.getUser().getId(),
                order.getLocalDateTime(),
                order.getCarList(),
                order.getTotalPrice());
    }
}
