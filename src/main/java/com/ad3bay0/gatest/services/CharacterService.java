package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.dto.CharacterFilterDto;
import com.ad3bay0.gatest.models.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService {

	Character save(CharacterDto dto);

	Page<Character> findAll(Pageable pageable);

	Page<Character> findAll(Pageable pageable, CharacterFilterDto character);
    
}