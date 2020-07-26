package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.repositories.EpisodeRepository;

import org.springframework.stereotype.Service;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    
    private EpisodeRepository episodeRepository;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository){

        this.episodeRepository = episodeRepository;

    }
}