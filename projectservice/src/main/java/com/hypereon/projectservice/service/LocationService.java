package com.hypereon.projectservice.service;

import java.util.List;

import com.hypereon.projectservice.model.Location;

public interface LocationService {
    public List<Location> findLocationsByIds(List<Long> locationIds);

    public List<String> findLocationNamesForIds(List<Long> locationids);

    public Location findLocationById(Long locationId);

    public Location addLocation(Location location);
}
