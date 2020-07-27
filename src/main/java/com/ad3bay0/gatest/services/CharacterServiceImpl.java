package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.models.Character;
import com.ad3bay0.gatest.repositories.CharacterRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository repository;
    private ModelMapper modelMapper;

    public CharacterServiceImpl(CharacterRepository repository, ModelMapper modelMapper) {

        this.repository = repository;
        this.modelMapper = modelMapper;

    }

    @Override
    public Character save(CharacterDto dto) {
        
        Character character = modelMapper.map(dto, Character.class);
        
        return this.repository.save(character);
    }
    
}