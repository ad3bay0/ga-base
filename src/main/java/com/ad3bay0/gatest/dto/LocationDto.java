package com.ad3bay0.gatest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LocationDto {


    @NotBlank(message = "location name is compulsory")
    private String name;

    @NotNull(message = "latitude is compulsory")
    private Double latitude;

    @NotNull(message = "longitude is compulsory")
    private Double longitude;
    
}