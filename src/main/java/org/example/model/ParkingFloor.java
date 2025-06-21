package org.example.model;

import org.example.data.ParkingSpots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    String id;
    List<Spots> parkingSpots = new ArrayList<>();
    Map<ParkingSpots,Integer> totalSpots = new HashMap<>();
    Map<ParkingSpots,Integer> availableSpots = new HashMap<>();

    public ParkingFloor(String id) {
        this.id = id;
        addSpots();
    }
    public void addSpots()
    {
        parkingSpots.add(new Spots("1",ParkingSpots.COMPACT));
        parkingSpots.add(new Spots("1",ParkingSpots.BIKE));
    }
    public void parkVehicle(Vehicle vehicle)
    {
        for(Spots spots:parkingSpots)
        {
            if(vehicle.getParkingSpot()==spots.getSpotType())
            {
                Spots spots1 = new Spots("sp1",vehicle.getParkingSpot());
                spots1.parkVehicle(vehicle);
                break;
            }
            else throw new IllegalArgumentException("Vehile not Parked from Parking Floor");
        }

    }
    public int getAvailbleCount(ParkingSpots spot)
    {
        if(availableSpots.containsKey(spot))
            return availableSpots.get(spot);
        return 0;
    }
    public void reduceCount(ParkingSpots spot)
    {
        availableSpots.put(spot,availableSpots.get(spot)-1);
    }
    public void increaseCount(ParkingSpots spot)
    {
        availableSpots.put(spot,availableSpots.get(spot)+1);
    }
    public void addSpots(ParkingSpots spot,int count)
    {
        totalSpots.put(spot,totalSpots.getOrDefault(spot,0)+count);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Spots> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<Spots> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Map<ParkingSpots, Integer> getTotalSpots() {
        return totalSpots;
    }

    public void setTotalSpots(Map<ParkingSpots, Integer> totalSpots) {
        this.totalSpots = totalSpots;
    }

    public Map<ParkingSpots, Integer> getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(Map<ParkingSpots, Integer> availableSpots) {
        this.availableSpots = availableSpots;
    }
}
