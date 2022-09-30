package com.restap.carshop.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CARS")
public class Car {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CAR_ID", unique = true)
    private Long ind;

    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;

    @OneToOne
    @JoinColumn(name = "MODEL_EXEMPLAR_ID")
    private ModelExemplar modelExemplar;

    @OneToOne
    @JoinColumn(name = "ENGINE_EXEMPLAR_ID")
    private EngineExemplar engineExemplar;

    @OneToOne
    @JoinColumn(name = "GEARBOX_EXEMPLAR_ID")
    private GearBoxExemplar gearBoxExemplar;

    @ManyToOne
    @JoinColumn(name = "COLOR_ID")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "DRIVE_ID")
    private Drive drive;

    @ManyToOne
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;

    /*
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    */
}
