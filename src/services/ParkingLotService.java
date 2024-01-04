package services;

import exceptions.NoSpotAvailableException;
import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;
import repository.ParkingLotRepository;
import strategy.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLotService {
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public ParkingSpot getParkingSpot(Vehicle vehicle, Gate gate) throws NoSpotAvailableException {
        List<ParkingSpot> parkingSpotList = parkingLotRepository.getAllParkingSlots();
        ParkingSpot spot = spotAssignmentStrategy.assignParkingSpot(vehicle.getVehicleType(), gate, parkingSpotList);
        if (spot == null) {
            throw new NoSpotAvailableException("No Empty Parking Spot available");
        }
        return null;
    }

    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.setParkingLot(parkingLot);
        return parkingLotRepository.getParkingLot();
    }
}
