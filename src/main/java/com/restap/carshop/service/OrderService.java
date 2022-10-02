package com.restap.carshop.service;

import com.restap.carshop.domain.Car;
import com.restap.carshop.domain.Order;
import com.restap.carshop.exception.OrderException;
import com.restap.carshop.repository.CarRepository;
import com.restap.carshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private CarRepository carRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(CarRepository carRepository, OrderRepository orderRepository) {
        this.carRepository = carRepository;
        this.orderRepository = orderRepository;
    }

    public Order addOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(final Long id) throws OrderException {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderException();
        }
    }

    public Order findOrderById(final Long id) throws OrderException {
        return orderRepository.findById(id).orElseThrow(OrderException::new);
    }
}
