package com.ad3bay0.gatest.controllers;

import javax.validation.Valid;

import com.ad3bay0.gatest.dto.EpisodeDto;
import com.ad3bay0.gatest.models.Episode;
import com.ad3bay0.gatest.services.EpisodeService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/episodes")
@Api(tags = "Episodes")
public class EpisodeController {
    
    private EpisodeService service;

    public EpisodeController(EpisodeService service){
        this.service = service;

    }

    @ApiOperation(value = "Create an episode")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Episode create(@Valid @RequestBody EpisodeDto episode){

        return service.save(episode);
    }
    
}