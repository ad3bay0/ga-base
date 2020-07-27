package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.models.Character;

public interface CharacterService {

	Character save(CharacterDto dto);
    
}