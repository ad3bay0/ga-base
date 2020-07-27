package com.ad3bay0.gatest.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CharacterDto {
  
    @NotBlank(message = "first name is mandatory")
    private String firstName;
    @NotBlank(message = "last name is mandatory")
    private String lastName;
    private String stateOfOrigin;
    @NotBlank(message = "status is mandatory")
    private String status;
    @NotBlank(message = "gender is mandatory")
    private String gender;
}