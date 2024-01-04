package services;

import enums.VehicleType;
import models.Vehicle;
import repository.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleRepository.getVehicle(vehicleNumber);
    }

    public Vehicle addVehicle(String vehicleNumber, VehicleType type) {
        Vehicle vehicle = new Vehicle(vehicleNumber, type);
        vehicleRepository.saveVehicle(vehicle);
        return vehicle;
    }
}
