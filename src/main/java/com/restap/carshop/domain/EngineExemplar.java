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
@Entity(name = "ENGINES_EXEMPLARS")
public class EngineExemplar {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ENGINE_EXEMPLAR_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @NotNull
    @Column(name = "IS_AVAILABLE")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "ENGINE_ID")
    private Engine engine;

    public EngineExemplar(Long id, String serialNumber, boolean available) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.available = available;
    }

    public EngineExemplar(String serialNumber, boolean available) {
        this.serialNumber = serialNumber;
        this.available = available;
    }
}
