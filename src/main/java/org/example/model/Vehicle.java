package org.example.model;

import org.example.data.ParkingSpots;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Vehicle {
    String id;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    public Vehicle(String id) {
        this.id = id;
    }

    public abstract ParkingSpots getParkingSpot();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
