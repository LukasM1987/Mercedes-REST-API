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
@Entity(name = "GEARBOXES_EXEMPLARS")
public class GearBoxExemplar {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GEARBOX_EXEMPLAR_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @NotNull
    @Column(name = "IS_AVAILABLE")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "GEARBOXES_ID")
    private GearBox gearbox;

    public GearBoxExemplar(Long id, String serialNumber, boolean available) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.available = available;
    }
}
