package com.ad3bay0.gatest.repositories;

import com.ad3bay0.gatest.models.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    
}