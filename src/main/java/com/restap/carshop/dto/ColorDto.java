package com.restap.carshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("colorName")
    private String colorName;

    @JsonProperty("price")
    private double price;
}
