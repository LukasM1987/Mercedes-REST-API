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
@Entity(name = "MODELS")
public class Model {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "MODEL_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "CAR_CLASS")
    private String carClass;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @OneToMany(targetEntity = ModelExemplar.class, mappedBy = "model", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ModelExemplar> modelExemplarList = new ArrayList<>();

    public Model(Long id, String carClass, String type, double price) {
        this.id = id;
        this.carClass = carClass;
        this.type = type;
        this.price = price;
    }
}
