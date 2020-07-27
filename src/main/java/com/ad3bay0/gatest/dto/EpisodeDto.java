package com.ad3bay0.gatest.dto;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EpisodeDto {

    @NotBlank(message = "name is mandatory")
    private String name;


    @NotNull(message = "release date is mandatory")
    private LocalDateTime releaseDate;


    @NotBlank(message = "episode code is mandatory")
    private String episodeCode;

}
