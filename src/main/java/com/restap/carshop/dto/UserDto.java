package com.restap.carshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("pesel")
    private String pesel;

    @JsonProperty("name")
    private String name;

    @JsonProperty("secondName")
    private String secondName;

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("house")
    private String house;

    @JsonProperty("local")
    private String local;

}
