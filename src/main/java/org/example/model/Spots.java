package org.example.model;

import org.example.data.ParkingSpots;

public class Spots {

    String id;
    boolean isVacant;
    ParkingSpots spotType;
    Vehicle parkedVehicle;

    public Spots(String id, ParkingSpots spotType) {
        this.id = id;
        this.isVacant = false;
        this.spotType = spotType;
    }

    public ParkingSpots getSpotType(){
        return spotType;
    }
    public void parkVehicle(Vehicle vehicle) {
        parkedVehicle = vehicle;
        isVacant = false;
        System.out.println("Vehicle parked at "+id);
    }
    public void removeVehicle() {
        parkedVehicle = null;
        isVacant = true;
        System.out.println("Vehicle removed from "+id);
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
