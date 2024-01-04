package repository;

import models.ParkingLot;
import models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {

    private ParkingLot parkingLot;

    public ParkingLotRepository() {
    }

    public void setParkingLot(ParkingLot lot) {
        this.parkingLot = lot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<ParkingSpot> getAllParkingSlots() {
        List<ParkingSpot> spots = new ArrayList<>();
        parkingLot.getParkingFloors().forEach((parkingFloor -> spots.addAll(parkingFloor.getParkingSpots())));
        return spots;
    }
}
