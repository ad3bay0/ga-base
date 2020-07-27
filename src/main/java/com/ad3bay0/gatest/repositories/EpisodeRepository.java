package com.ad3bay0.gatest.repositories;

import com.ad3bay0.gatest.dto.EpisodeDto;
import com.ad3bay0.gatest.models.Episode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("select new com.ad3bay0.gatest.dto.EpisodeDto(e.id, e.name,e.releaseDate,e.episodeCode,size(e.episodeComments)) from Episode e ORDER BY e.releaseDate ASC")
    Page<EpisodeDto> findAllOrderByReleasedDateAsc(Pageable pageable);
    
}