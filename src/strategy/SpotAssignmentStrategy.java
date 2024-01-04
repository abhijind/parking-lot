package strategy;

import enums.VehicleType;
import models.Gate;
import models.ParkingSpot;

import java.util.List;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignParkingSpot(VehicleType type, Gate gate, List<ParkingSpot> parkingSpots);
}
