package services;

import enums.ParkingSpotStatus;
import exceptions.NoSpotAvailableException;
import models.Gate;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import repository.TicketRepository;

import java.util.Date;

public class TicketService {

    private TicketRepository ticketRepository;

    private VehicleService vehicleService;

    private OperatorService operatorService;

    private ParkingSpotService parkingSpotService;

    private GateService gateService;

    public Ticket generateTicket(Vehicle vehicle, Long gateId) throws NoSpotAvailableException {

        // vehicle DB entry check
        if (vehicleService.getVehicle(vehicle.getVehicleNumber()) == null) {
            vehicle = vehicleService.addVehicle(vehicle.getVehicleNumber(), vehicle.getVehicleType());
        }

        // get gate and operator details
        Gate gate = gateService.getGate(gateId);

        // generate parking spot
        ParkingSpot spot = parkingSpotService.getParkingSpot(vehicle, gate);

        // set parking spot as assigned
        parkingSpotService.updateParkingSpot(spot, ParkingSpotStatus.OCCUPIED);

        // generate ticket
        Ticket ticket = new Ticket();

        ticket.setOperator(gate.getOperator());
        ticket.setParkingSpot(spot);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);

        // return generated ticket
        return ticket;
    }
}
