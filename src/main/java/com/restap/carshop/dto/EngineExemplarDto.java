package com.restap.carshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineExemplarDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("serialNumber")
    private String serialNumber;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("engineId")
    private Long engineId;
}
