package com.ad3bay0.gatest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping
@Api(tags = "Home API")
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "welcome";

    }
    
}