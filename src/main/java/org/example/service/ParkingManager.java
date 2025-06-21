package org.example.service;

import org.example.data.ParkingSpots;
import org.example.data.VehicleType;
import org.example.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    Map<String,ParkingFloor> parkingFloorMap = new HashMap<>();
    public void addParkingFloor(ParkingFloor parkingFloor)
    {
        HashMap<ParkingSpots,Integer> availableSpot = new HashMap<>();
        availableSpot.put(ParkingSpots.COMPACT,10);
        availableSpot.put(ParkingSpots.BIKE,10);
        parkingFloor.setAvailableSpots(availableSpot);
        parkingFloorMap.put(parkingFloor.getId(),parkingFloor);
    }
    public void park(Vehicle vehicle,String floorId)
    {
        ParkingSpots parkingSpots = vehicle.getParkingSpot();
        if(parkingFloorMap.get(floorId).getAvailbleCount(parkingSpots)>0)
        {
            vehicle.setEntryTime(LocalDateTime.now());
            parkingFloorMap.get(floorId).reduceCount(parkingSpots);
            System.out.println("Vehicle parked successfully");
        }
        else
            System.out.println("Vehicle not parked");
    }
    public void exit(Vehicle vehicle,String floorId)
    {
        vehicle.setExitTime(LocalDateTime.now());
        parkingFloorMap.get(floorId).increaseCount(vehicle.getParkingSpot());
        System.out.println("Vehicle Exited successfully");
    }
}
