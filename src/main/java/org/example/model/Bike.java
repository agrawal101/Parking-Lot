package org.example.model;

import org.example.data.ParkingSpots;

public class Bike extends Vehicle{

    public Bike(String id)
    {
        super(id);
    }
    @Override
    public ParkingSpots getParkingSpot()
    {
        return ParkingSpots.BIKE;
    }
}
