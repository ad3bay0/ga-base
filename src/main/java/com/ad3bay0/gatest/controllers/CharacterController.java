package com.ad3bay0.gatest.controllers;

import javax.validation.Valid;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.models.Character;
import com.ad3bay0.gatest.services.CharacterService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/characters")
@Api(tags = "Characters")
public class CharacterController {

    private CharacterService service;

    public CharacterController(CharacterService service){
        this.service = service;

    }

    @ApiOperation(value = "Create a character")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Character create(@Valid @RequestBody CharacterDto character){

        return service.save(character);
    }
    
}