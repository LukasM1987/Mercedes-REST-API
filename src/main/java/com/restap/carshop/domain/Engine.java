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
@Entity(name = "ENGINES")
public class Engine {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ENGINE_ID")
    private Long id;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @NotNull
    @Column(name = "HORSE_POWER")
    private int hp;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @OneToMany(targetEntity = EngineExemplar.class, mappedBy = "engine", cascade = CascadeType.ALL)
    private List<EngineExemplar> engineExemplarList = new ArrayList<>();

    public Engine(Long id, String type, int hp, double price) {
        this.id = id;
        this.type = type;
        this.hp = hp;
        this.price = price;
    }
}
