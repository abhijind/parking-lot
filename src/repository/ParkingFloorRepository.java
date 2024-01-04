package repository;

import exceptions.FloorAlreadyExistsException;
import models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private final Map<Integer, ParkingFloor> floorStore;

    public ParkingFloorRepository() {
        this.floorStore = new HashMap<>();
    }

    public ParkingFloor getParkingFloor(Integer floorNumber) {
        return this.floorStore.get(floorNumber);
    }

    public ParkingFloor addParkingFloor(ParkingFloor floor) throws FloorAlreadyExistsException {
        if (this.floorStore.containsKey(floor.getFloorNumber())) {
            throw new FloorAlreadyExistsException("Floor data already exists");
        }
        this.floorStore.put(floor.getFloorNumber(), floor);
        return floor;
    }

}
