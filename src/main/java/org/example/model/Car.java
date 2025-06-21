package org.example.model;

import org.example.data.ParkingSpots;

public class Car extends Vehicle{

    public Car(String id) {
        super(id);
    }

    @Override
    public ParkingSpots getParkingSpot()
    {
        return ParkingSpots.COMPACT;
    }
}
