package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.dto.CommentDto;
import com.ad3bay0.gatest.dto.EpisodeDto;
import com.ad3bay0.gatest.models.Episode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EpisodeService {

	Episode save(EpisodeDto episode);

	Page<EpisodeDto> findAll(Pageable pageable);

	Episode addComment(CommentDto comment, Integer episodeId);
    
}