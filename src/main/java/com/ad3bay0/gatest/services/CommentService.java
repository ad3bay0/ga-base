package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.models.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

	Page<Comment> findAll(Pageable pageable);
    
}