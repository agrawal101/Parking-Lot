package org.example.model;

import org.example.data.ParkingSpots;

public class Spots {

    String id;
    boolean isVacant;
    ParkingSpots spotType;

    public Spots(String id, boolean isVacant, ParkingSpots spotType) {
        this.id = id;
        this.isVacant = isVacant;
        this.spotType = spotType;
    }

    public ParkingSpots getSpotType(){
        return spotType;
    }
    public void markOccupied() {
        isVacant = false;
    }
    public void markVacant() {
        isVacant = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public void setVacant(boolean vacant) {
        isVacant = vacant;
    }

    public void setSpotType(ParkingSpots spotType) {
        this.spotType = spotType;
    }
}
