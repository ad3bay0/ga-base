package com.ad3bay0.gatest.services;

import javax.validation.Valid;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.dto.CharacterFilterDto;
import com.ad3bay0.gatest.dto.LocationDto;
import com.ad3bay0.gatest.models.Character;
import com.ad3bay0.gatest.models.Episode;
import com.ad3bay0.gatest.models.Location;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService {

	Character save(CharacterDto dto);

	Page<Character> findAll(Pageable pageable);

	Page<Character> findAll(Pageable pageable, CharacterFilterDto filter);

	Page<Episode> getEpisodesByCharacterId(Pageable pageable, Integer characterId);

	Location addLocation(LocationDto location, Integer characterId);
    
}