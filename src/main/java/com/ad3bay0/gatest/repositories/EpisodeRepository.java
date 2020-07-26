package com.ad3bay0.gatest.repositories;

import com.ad3bay0.gatest.models.Episode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    
}