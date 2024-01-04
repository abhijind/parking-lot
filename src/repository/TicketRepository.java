package repository;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private final Map<Long, Ticket> ticketStore;

    private Long counter;

    public TicketRepository() {
        ticketStore = new HashMap<>();
        counter = 0L;
    }

    public Ticket getTicket(Long ticketId) {
        return ticketStore.get(ticketId);
    }

    public Ticket saveTicket(Ticket ticket) {
        ticket.setId(counter);
        ticketStore.put(counter++, ticket);
        return ticket;
    }
}
