package services;

import enums.ParkingSpotStatus;
import exceptions.NoSpotAvailableException;
import models.Gate;
import models.ParkingSpot;
import models.Vehicle;
import repository.ParkingSpotRepository;

public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;

    private ParkingLotService parkingLotService;

    public ParkingSpot updateParkingSpot(ParkingSpot spot, ParkingSpotStatus status) {
        ParkingSpot parkingSpot = parkingSpotRepository.getParkingSpot(spot.getId());
        parkingSpot.setParkingSpotStatus(status);
        return parkingSpot;
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle, Gate gate) throws NoSpotAvailableException {
        return parkingLotService.getParkingSpot(vehicle, gate);
    }
}
