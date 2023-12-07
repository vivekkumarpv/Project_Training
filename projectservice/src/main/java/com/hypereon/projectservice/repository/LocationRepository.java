package com.hypereon.projectservice.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hypereon.projectservice.model.Location;

public interface LocationRepository extends MongoRepository<Location, Long> {
    public Optional<Location> findByLocationId(Long locationId);
}

