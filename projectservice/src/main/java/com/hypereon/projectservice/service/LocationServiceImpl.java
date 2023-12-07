package com.hypereon.projectservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hypereon.projectservice.exception.LocationAlreadyExistException;
import com.hypereon.projectservice.exception.LocationNotFoundException;
import com.hypereon.projectservice.model.Location;
import com.hypereon.projectservice.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> findLocationsByIds(List<Long> locationIds) {
        List<Location> locationList = new ArrayList<>();
        for (Long id : locationIds) {
            Optional<Location> location = locationRepository.findByLocationId(id);
            if (location.isPresent()) {
                locationList.add(location.get());
            } else {
                throw new LocationNotFoundException("Location with ID " + id + " not found");
            }
        }
        return locationList;

    }

    @Override
    public List<String> findLocationNamesForIds(List<Long> locationIds) {
        List<String> locationNamesList = new ArrayList<>();
        for (Long id : locationIds) {
            Optional<Location> location = locationRepository.findByLocationId(id);
            if (location.isPresent()) {
                locationNamesList.add(location.get().getRoomNo());
            } else {
                throw new LocationNotFoundException("Location with ID " + id + " not found");
            }
        }
        return locationNamesList;
    }

    @Override
    public Location findLocationById(Long locationId) {
        Optional<Location> location = locationRepository.findByLocationId(locationId);
        if (location.isPresent()) {
            return location.get();
        } else {
            throw new LocationNotFoundException("Location with ID " + locationId + " not found");
        }
    }

    @Override
    public Location addLocation(Location location) {
        Optional<Location> optLocation = locationRepository.findByLocationId(location.getLocationId());
        if (optLocation.isPresent()) {
            throw new LocationAlreadyExistException("Jobrole with id " + location.getLocationId() + " already exists");
        }
        return locationRepository.save(location);
    }

}
