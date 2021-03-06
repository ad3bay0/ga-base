package com.ad3bay0.gatest.controllers;

import javax.validation.Valid;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.dto.CharacterFilterDto;
import com.ad3bay0.gatest.dto.LocationDto;
import com.ad3bay0.gatest.models.Character;
import com.ad3bay0.gatest.models.Episode;
import com.ad3bay0.gatest.models.Location;
import com.ad3bay0.gatest.services.CharacterService;
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
@RequestMapping("/characters")
@Api(tags = "Characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService service;

    @ApiOperation(value = "Create a character")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Character create(@Valid @RequestBody CharacterDto character){

        return service.save(character);
    }


    @ApiOperation(value = "List of characters")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Character> getAll(Pageable pageable, CharacterFilterDto filter){

        return service.findAll(pageable,filter);
    }

    @ApiOperation(value = "List of character's episodes")
    @GetMapping("/{characterId}/episodes")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Episode> getCharacterEpisodes( @PathVariable("characterId") Integer characterId, Pageable pageable){

        return service.getEpisodesByCharacterId(pageable,characterId);
    }


    @ApiOperation(value = "Add chracter location")
    @PostMapping("/{characterId}/add-location")
    @ResponseStatus(code = HttpStatus.OK)
    public Location addLocation(@PathVariable("characterId") Integer characterId, 
                          @Valid @RequestBody LocationDto location){

        return service.addLocation(location, characterId);
    }
    
}