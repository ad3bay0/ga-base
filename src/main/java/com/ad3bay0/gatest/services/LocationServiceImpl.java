package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.repositories.LocationRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    
}