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
public class SeatDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("material")
    private String material;

    @JsonProperty("color")
    private String color;

    @JsonProperty("price")
    private double price;
}
