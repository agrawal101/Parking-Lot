import org.example.data.ParkingSpots;
import org.example.model.*;
import org.example.service.ParkingManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotManagerTest {

    private ParkingManager manager;

    @BeforeEach
    public void setup() {
        manager = new ParkingManager();
        ParkingFloor floor = new ParkingFloor("F1");

        // Add spots to floor
        floor.addSpots(new Spots("S1", ParkingSpots.COMPACT));
        floor.addSpots(new Spots("S2", ParkingSpots.LARGE));
        floor.addSpots(new Spots("S3", ParkingSpots.BIKE));

        manager.addParkingFloor(floor);
    }

    @Test
    public void testVehicleEntry_Success() {
        Vehicle car = new Car("C1");
        boolean result = manager.park(car,"F1");

        assertTrue(result);
        assertNotNull(car.getEntryTime());
    }

    @Test
    public void testVehicleEntry_NoAvailableSpot() {
        // Fill the only LARGE spot
        manager.park(new Truck("T1"),"F1");
        // Try another truck
        boolean result = manager.park(new Truck("T2"),"F1");

        assertFalse(result);
    }

    @Test
    public void testVehicleExit_FreeSpotAndTimeCaptured() throws InterruptedException {
        Vehicle car = new Car("C2");
        manager.park(car,"F1");
        Thread.sleep(1000); // simulate time
        boolean exitSuccess = manager.exit(car,"F1");

        assertTrue(exitSuccess);
        assertNotNull(car.getExitTime());


    }

//    @Test
//    public void testVehicleExit_NotPresent() {
//        boolean result = manager.exit("X9");
//        assertFalse(result);
//    }

    @Test
    public void testDoubleEntryPrevention() {
        Vehicle car = new Car("C3");
        assertTrue(manager.park(car,"F1"));
        assertFalse(manager.park(car,"F1"));
    }
}
