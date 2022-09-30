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
public class ModelDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("carClass")
    private String carClass;

    @JsonProperty("type")
    private String type;

    @JsonProperty("price")
    private double price;
}
