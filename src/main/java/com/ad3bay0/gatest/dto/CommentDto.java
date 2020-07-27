package com.ad3bay0.gatest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommentDto {

    @Size(max = 250)
    private String comment;

    @NotBlank(message = "ip address is mandatory")
    private String ipAddressLocation;
    
}