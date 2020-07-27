package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.models.Comment;
import com.ad3bay0.gatest.repositories.CommentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {

        this.repository = repository;
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {

        return this.repository.findAllByOrderByCreatedDesc(pageable);
    }
    
}