package com.ad3bay0.gatest.services;


import com.ad3bay0.gatest.dto.EpisodeDto;
import com.ad3bay0.gatest.models.Episode;

public interface EpisodeService {

	Episode save(EpisodeDto episode);
    
}