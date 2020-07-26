package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.repositories.CharacterRepository;

import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService{

    private CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository){

        this.characterRepository = characterRepository;

    }
    
}