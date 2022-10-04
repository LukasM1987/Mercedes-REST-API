package com.restap.carshop.service;

import com.restap.carshop.domain.Car;
import com.restap.carshop.domain.Order;
import com.restap.carshop.exception.CarException;
import com.restap.carshop.exception.OrderException;
import com.restap.carshop.repository.CarRepository;
import com.restap.carshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Order addCarToTheOrder(final Long orderId, final Long carId) throws OrderException, CarException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderException::new);
        Car car = carRepository.findById(carId).orElseThrow(CarException::new);
        if (carRepository.findById(carId).get().isAvailable()) {
            //carRepository.findById(carId).get().setAvailable(false);
            car.setOrder(order);
            carRepository.save(car);
            order.getCarList().add(car);
            double finalPrice = 0;
            for (int i = 0; i < order.getCarList().size(); i++) {
                finalPrice = finalPrice + order.getCarList().get(i).getCarPrice();
            }
            order.setTotalPrice(finalPrice);
            return orderRepository.save(order);
        } else {
            throw new CarException();
        }
    }
}
