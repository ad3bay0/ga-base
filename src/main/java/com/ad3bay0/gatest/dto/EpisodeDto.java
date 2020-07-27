package com.ad3bay0.gatest.dto;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = { "commentsCount" }, allowGetters = true)
public class EpisodeDto {

    private Integer id;

    @NotBlank(message = "name is mandatory")
    private String name;


    @NotNull(message = "release date is mandatory")
    private LocalDateTime releaseDate;


    @NotBlank(message = "episode code is mandatory")
    private String episodeCode;

    private int commentsCount;

}
