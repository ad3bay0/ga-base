package com.ad3bay0.gatest.controllers;

import javax.validation.Valid;

import com.ad3bay0.gatest.dto.CommentDto;
import com.ad3bay0.gatest.dto.EpisodeDto;
import com.ad3bay0.gatest.models.Episode;
import com.ad3bay0.gatest.services.EpisodeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/episodes")
@Api(tags = "Episodes")
@RequiredArgsConstructor
public class EpisodeController {
    
    private final EpisodeService service;


    @ApiOperation(value = "Create an episode")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Episode create(@Valid @RequestBody EpisodeDto episode){

        return service.save(episode);
    }


    @ApiOperation(value = "List of episodes")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<EpisodeDto> getAll(Pageable pageable){

        return service.findAll(pageable);
    }



    @ApiOperation(value = "Add comment to episode")
    @PostMapping("/{episodeId}/comment")
    @ResponseStatus(code = HttpStatus.OK)
    public Episode create(@PathVariable("episodeId") Integer episodeId, 
                          @Valid @RequestBody CommentDto comment){

        return service.addComment(comment, episodeId);
    }
    
}