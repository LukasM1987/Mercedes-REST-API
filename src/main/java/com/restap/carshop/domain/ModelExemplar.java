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
@Entity(name = "MODEL_EXEMPLARS")
public class ModelExemplar {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "MODEL_EXEMPLAR_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "VIN_NUMBER")
    private String vin;

    @NotNull
    @Column(name = "IS_AVAILABLE")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "MODEL_ID")
    private Model model;

    public ModelExemplar(Long id, String vin, boolean available) {
        this.id = id;
        this.vin = vin;
        this.available = available;
    }
}
