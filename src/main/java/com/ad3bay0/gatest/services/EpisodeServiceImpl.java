package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.dto.EpisodeDto;
import com.ad3bay0.gatest.models.Episode;
import com.ad3bay0.gatest.repositories.EpisodeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    private EpisodeRepository repository;
    private ModelMapper modelMapper;

    public EpisodeServiceImpl(EpisodeRepository repository, ModelMapper modelMapper) {

        this.repository = repository;
        this.modelMapper = modelMapper;

    }

    @Override
    public Episode save(EpisodeDto dto) {
        
        Episode episode = modelMapper.map(dto, Episode.class);
        
        return this.repository.save(episode);

    }
}