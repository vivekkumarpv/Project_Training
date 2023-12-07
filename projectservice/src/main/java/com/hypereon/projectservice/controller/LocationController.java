package com.hypereon.projectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hypereon.projectservice.model.Location;
import com.hypereon.projectservice.service.LocationService;

@RestController
@RequestMapping("/api/location")
@CrossOrigin("*")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/id")
    public ResponseEntity<Location> getLocationByLocationId(@RequestParam Long locationId) {
        return ResponseEntity.ok().body(locationService.findLocationById(locationId));
    }

    @GetMapping("/ids")
    public ResponseEntity<List<Location>> getLocationsByLocationIds(@RequestParam List<Long> locationIds) {
        return ResponseEntity.ok().body(locationService.findLocationsByIds(locationIds));
    }

    @GetMapping("/getlocationnames")
    public ResponseEntity<List<String>> getLocationNamesByLocationIds(@RequestParam List<Long> locationIds) {
        return ResponseEntity.ok().body(locationService.findLocationNamesForIds(locationIds));
    }

    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        return ResponseEntity.accepted().body(locationService.addLocation(location));
    }
}
