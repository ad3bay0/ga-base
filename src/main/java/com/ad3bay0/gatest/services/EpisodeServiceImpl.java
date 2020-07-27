package com.ad3bay0.gatest.services;

import javax.persistence.EntityNotFoundException;

import com.ad3bay0.gatest.dto.CommentDto;
import com.ad3bay0.gatest.dto.EpisodeDto;
import com.ad3bay0.gatest.models.Comment;
import com.ad3bay0.gatest.models.Episode;
import com.ad3bay0.gatest.repositories.CommentRepository;
import com.ad3bay0.gatest.repositories.EpisodeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {

    private final EpisodeRepository repository;
    private final ModelMapper modelMapper;
    private final CommentRepository commentRepository;

    @Override
    public Episode save(EpisodeDto dto) {

        Episode episode = modelMapper.map(dto, Episode.class);

        return this.repository.save(episode);

    }

    @Override
    public Page<EpisodeDto> findAll(Pageable pageable) {

        return this.repository.findAllOrderByReleasedDateAsc(pageable);
    }

    @Override
    public Episode addComment(CommentDto dto, Integer episodeId) {
        
         Episode episode = this.repository.findById(episodeId)
                                       .orElseThrow(()-> new EntityNotFoundException());

         Comment comment = modelMapper.map(dto, Comment.class);

         comment = commentRepository.save(comment);

         episode.addComment(comment);

        return this.repository.save(episode);
    }

    
}