package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.models.Location;
import com.ad3bay0.gatest.repositories.LocationRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    @Override
    public Page<Location> findAll(Pageable pageable) {
       
        return repository.findAll(pageable);
    }

    
}