package org.example.model;

import org.example.data.ParkingSpots;

public class Truck extends Vehicle{

    public Truck(String id)
    {
        super(id);
    }
    @Override
    public ParkingSpots getParkingSpot()
    {
        return ParkingSpots.LARGE;
    }
}
