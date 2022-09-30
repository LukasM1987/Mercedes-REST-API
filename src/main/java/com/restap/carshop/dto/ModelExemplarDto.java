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
public class ModelExemplarDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("vin")
    private String vin;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("modelId")
    private Long modelId;
}
