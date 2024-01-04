package dtos;

import models.Vehicle;

import java.util.Date;

public class RequestTicketDTO {
    private Vehicle vehicle;

    private Date startTime;

    private Long gateId;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public Long getGateId() {
        return this.gateId;
    }
}
