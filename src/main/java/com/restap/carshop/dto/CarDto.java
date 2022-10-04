package com.restap.carshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restap.carshop.domain.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("carPrice")
    private double carPrice;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("modelExemplarId")
    private Long modelExemplarId;

    @JsonProperty("engineExemplarId")
    private Long engineExemplarId;

    @JsonProperty("gearBoxExemplarId")
    private Long gearBoxExemplarId;

    @JsonProperty("colorId")
    private Long colorId;

    @JsonProperty("driveId")
    private Long driveId;

    @JsonProperty("seatId")
    private Long seatId;
}
