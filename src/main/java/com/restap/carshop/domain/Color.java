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
@Entity(name = "COLORS")
public class Color {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COLOR_ID")
    private Long id;

    @NotNull
    @Column(name = "COLOR_NAME")
    private String colorName;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @OneToMany(targetEntity = Car.class, mappedBy = "color")
    private List<Car> carList = new ArrayList<>();

    public Color(Long id, String colorName, double price) {
        this.id = id;
        this.colorName = colorName;
        this.price = price;
    }
}
