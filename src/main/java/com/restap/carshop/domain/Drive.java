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
//@AllArgsConstructor
@Entity(name = "DRIVES")
public class Drive {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "DRIVE_ID")
    private Long id;

    @NotNull
    @Column(name = "DRIVE_TYPE")
    private String type;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @OneToMany(targetEntity = Car.class, mappedBy = "drive", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Car> carList = new ArrayList<>();

    public Drive(Long id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }
}
