package strategy;

import enums.ParkingSpotStatus;
import enums.VehicleType;
import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public ParkingSpot assignParkingSpot(VehicleType type, Gate gate, List<ParkingSpot> parkingSpots) {
        // find first empty parking spot which suits vehicle type.
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getParkingSpotStatus() == ParkingSpotStatus.EMPTY && spot.getSupportedVehicleTypes().contains(type)) {
                return spot;
            }
        }

        return null;
    }
}
