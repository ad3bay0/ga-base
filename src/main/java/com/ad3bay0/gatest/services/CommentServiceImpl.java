package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.repositories.CommentRepository;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository){

        this.commentRepository = commentRepository;
    }
    
}