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
@Entity(name = "GEARBOXES")
public class GearBox {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GEARBOXES_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "TYPE")
    private String type;

    @NotNull
    @Column(name = "GEARS_QUANTITY")
    private int gearsQuantity;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @OneToMany(targetEntity = GearBoxExemplar.class, mappedBy = "gearbox", cascade = CascadeType.ALL)
    private List<GearBoxExemplar> gearBoxExemplarList = new ArrayList<>();

    public GearBox(Long id, String type, int gearsQuantity, double price) {
        this.id = id;
        this.type = type;
        this.gearsQuantity = gearsQuantity;
        this.price = price;
    }
}
