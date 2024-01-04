package repository;


import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

// Either
// 1. we can have a vehicle repository to store the vehicle details for
// parking lots where the same vehicle re-visit on frequent basis (example - employees, cab stands)
// or
// 2. identify the vehicle in realtime and assign the spot without saving vehicle information.
// We will go with first approach.
public class VehicleRepository {
    // vehicleNumber -> vehicle details
    private final Map<String, Vehicle> vehicleStore;

    private Long counter;
    public VehicleRepository() {
        vehicleStore = new HashMap<>();
        counter = 0L;
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleStore.get(vehicleNumber);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        vehicle.setId(counter++);
        vehicleStore.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }

}
