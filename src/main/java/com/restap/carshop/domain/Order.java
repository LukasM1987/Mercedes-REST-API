package com.restap.carshop.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @NotNull
    @Column(name = "ORDER_CREATION_DATE")
    private LocalDateTime localDateTime;

    /*
    @OneToMany(targetEntity = Car.class, mappedBy = "order", cascade = CascadeType.ALL)
    private List<Car> carList = new ArrayList<>();
    */

    @NotNull
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @OneToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;


}
