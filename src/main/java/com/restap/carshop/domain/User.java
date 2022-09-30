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
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID")
    private Long id;

    @NotNull
    @Column(name = "PESEL")
    private String pesel;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "SECOND_NAME")
    private String secondName;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @NotNull
    @Column(name = "HOUSE")
    private String house;

    @Column(name = "LOCAL")
    private String local;

    @OneToMany(targetEntity = Order.class, mappedBy = "user")
    List<Order> orderList = new ArrayList<>();

    public User(Long id, String pesel, String name, String secondName, String city, String street, String house, String local) {
        this.id = id;
        this.pesel = pesel;
        this.name = name;
        this.secondName = secondName;
        this.city = city;
        this.street = street;
        this.house = house;
        this.local = local;
    }
}
