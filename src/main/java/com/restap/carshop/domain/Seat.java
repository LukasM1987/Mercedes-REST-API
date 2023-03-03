package com.restap.carshop.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SEATS")
public class Seat {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "SEAT_ID")
    private Long id;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @NotNull
    @Column(name = "MATERIAL")
    private String material;

    @NotNull
    @Column(name = "COLOR")
    private String color;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @OneToMany(targetEntity = Car.class, mappedBy = "seat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Car> carList = new ArrayList<>();

    public Seat(Long id, String type, String material, String color, double price) {
        this.id = id;
        this.type = type;
        this.material = material;
        this.color = color;
        this.price = price;
    }

    public Seat(String type, String material, String color, double price) {
        this.type = type;
        this.material = material;
        this.color = color;
        this.price = price;
    }
}
