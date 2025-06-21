package org.example;

import org.example.model.Car;
import org.example.model.ParkingFloor;
import org.example.model.Vehicle;
import org.example.service.ParkingManager;

public class Main {
    public static void main(String[] args) {
        ParkingFloor parkingFloor = new ParkingFloor("1");
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.addParkingFloor(parkingFloor);
        Vehicle vehicle = new Car("c1");
        parkingManager.park(vehicle,"1");

    }
}