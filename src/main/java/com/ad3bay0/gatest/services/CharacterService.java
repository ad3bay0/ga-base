package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.dto.CharacterFilterDto;
import com.ad3bay0.gatest.models.Character;
import com.ad3bay0.gatest.models.Episode;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService {

	Character save(CharacterDto dto);

	Page<Character> findAll(Pageable pageable);

	Page<Character> findAll(Pageable pageable, CharacterFilterDto character);

	Page<Episode> getEpisodesByCharacterId(Pageable pageable, Integer characterId);
    
}