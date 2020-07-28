package com.ad3bay0.gatest.services;

import javax.persistence.EntityNotFoundException;

import com.ad3bay0.gatest.dto.CharacterDto;
import com.ad3bay0.gatest.dto.CharacterFilterDto;
import com.ad3bay0.gatest.dto.LocationDto;
import com.ad3bay0.gatest.models.Character;
import com.ad3bay0.gatest.models.Episode;
import com.ad3bay0.gatest.models.Location;
import com.ad3bay0.gatest.repositories.CharacterRepository;
import com.ad3bay0.gatest.repositories.EpisodeRepository;
import com.ad3bay0.gatest.repositories.LocationRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;
    private final EpisodeRepository episodeRepository;
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    @Override
    public Character save(CharacterDto dto) {

        Character character = modelMapper.map(dto, Character.class);

        return repository.save(character);
    }

    @Override
    public Page<Character> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public Page<Character> findAll(Pageable pageable, CharacterFilterDto filter) {

        Character character = modelMapper.map(filter, Character.class);
        return repository.findAll(Example.of(character), pageable);
    }

    @Override
    public Page<Episode> getEpisodesByCharacterId(Pageable pageable, Integer id) {

        return episodeRepository.findByCharactersId(id, pageable);
    }

    @Override
    public Location addLocation(LocationDto dto, Integer characterId) {

        Character character = this.repository.findById(characterId).orElseThrow(()-> new EntityNotFoundException());
        Location location = modelMapper.map(dto, Location.class);
        location.setCharacter(character);

        return locationRepository.save(location);
    }
    
}