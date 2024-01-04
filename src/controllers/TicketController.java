package controllers;

import dtos.BaseResponseDTO;
import dtos.RequestTicketDTO;
import dtos.ResponseTicketDTO;
import exceptions.NoSpotAvailableException;
import models.Ticket;
import services.TicketService;

public class TicketController {
    TicketService ticketService;

    public BaseResponseDTO<ResponseTicketDTO> generateTicket(RequestTicketDTO request) {
        try {
            Ticket ticket = ticketService.generateTicket(request.getVehicle(), request.getGateId());
        } catch (NoSpotAvailableException e) {
            BaseResponseDTO<ResponseTicketDTO> response = new BaseResponseDTO<ResponseTicketDTO>();
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            return response;
        }
        return new BaseResponseDTO<ResponseTicketDTO>();
    }
}
