package com.ad3bay0.gatest.controllers;

import com.ad3bay0.gatest.models.Comment;
import com.ad3bay0.gatest.services.CommentService;

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
@RequestMapping("/comments")
@Api(tags = "Comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;



    @ApiOperation(value = "List of comments")
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<Comment> getAll(Pageable pageable){

        return service.findAll(pageable);
    }
    
}