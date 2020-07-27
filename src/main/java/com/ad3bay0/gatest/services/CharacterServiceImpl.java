package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.dto.CharacterFilterDto;
import com.ad3bay0.gatest.models.Character;
import com.ad3bay0.gatest.repositories.CharacterRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Character> findAll(Pageable pageable) {
        
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<Character> findAll(Pageable pageable, CharacterFilterDto dto) {
        
        Character character = modelMapper.map(dto, Character.class);
        return repository.findAll(Example.of(character), pageable);
    }
    
}