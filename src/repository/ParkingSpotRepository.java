package repository;

import models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private final Map<Long, ParkingSpot> parkingSpotStore;

    private Long counter;

    public ParkingSpotRepository() {
        parkingSpotStore = new HashMap<>();
        counter = 0L;
    }

    public ParkingSpot getParkingSpot(Long parkingSpotId) {
        return parkingSpotStore.get(parkingSpotId);
    }

    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setId(counter);
        parkingSpotStore.put(counter++, parkingSpot);
        return parkingSpot;
    }
}
