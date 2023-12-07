package com.hypereon.projectservice.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location {

    private long locationId;
    private String roomNo;
    private String state;
    private String country;
    private String countryCode;
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Location() {
    }

    public Location(long locationId, String roomNo, String state, String country, String countryCode,
            LocalDateTime createdAt, LocalDateTime modifiedAt) {

        this.locationId = locationId;
        this.roomNo = roomNo;
        this.state = state;
        this.country = country;
        this.countryCode = countryCode;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

}
