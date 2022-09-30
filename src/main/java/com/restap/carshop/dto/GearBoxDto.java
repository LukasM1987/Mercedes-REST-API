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
public class GearBoxDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("gearsQuantity")
    private int gearsQuantity;

    @JsonProperty("price")
    private double price;
}
