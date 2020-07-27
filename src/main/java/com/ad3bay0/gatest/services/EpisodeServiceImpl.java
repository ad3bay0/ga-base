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
import org.springframework.transaction.annotation.Transactional;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    private EpisodeRepository repository;
    private ModelMapper modelMapper;
    private CommentRepository commentRepository;

    public EpisodeServiceImpl(EpisodeRepository repository, ModelMapper modelMapper, CommentRepository commentRepository) {

        this.repository = repository;
        this.modelMapper = modelMapper;
        this.commentRepository = commentRepository;

    }

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