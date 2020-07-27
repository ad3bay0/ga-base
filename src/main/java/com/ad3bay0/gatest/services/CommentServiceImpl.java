package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.models.Comment;
import com.ad3bay0.gatest.repositories.CommentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    @Override
    public Page<Comment> findAll(Pageable pageable) {

        return this.repository.findAllByOrderByCreatedDesc(pageable);
    }
    
}