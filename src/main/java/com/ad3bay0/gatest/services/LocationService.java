package com.ad3bay0.gatest.services;

import com.ad3bay0.gatest.models.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LocationService {

	Page<Location> findAll(Pageable pageable);
    
}