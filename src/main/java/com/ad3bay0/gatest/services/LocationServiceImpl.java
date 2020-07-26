package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.repositories.LocationRepository;

import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository){

        this.locationRepository = locationRepository;

    }
    
}