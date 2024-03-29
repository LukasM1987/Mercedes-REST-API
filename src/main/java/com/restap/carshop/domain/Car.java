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
    private Long id;

    @Column(name = "CAR_PRICES")
    private double carPrice;

    @NotNull
    @Column(name = "AVAILABLE")
    private boolean available;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MODEL_EXEMPLAR_ID")
    private ModelExemplar modelExemplar;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ENGINE_EXEMPLAR_ID")
    private EngineExemplar engineExemplar;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public Car(Long id, boolean available) {
        this.id = id;
        this.available = available;
    }

    public Car(boolean available) {
        this.available = available;
    }
}
