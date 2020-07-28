package com.ad3bay0.gatest.controllers;

import com.ad3bay0.gatest.models.Location;
import com.ad3bay0.gatest.services.LocationService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/locations")
@Api(tags = "Locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService service;
    


    @ApiOperation(value = "List of locations")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Location> getAll(Pageable pageable){

        return service.findAll(pageable);
    }
}