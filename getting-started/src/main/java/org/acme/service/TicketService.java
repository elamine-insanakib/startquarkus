package org.acme.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.acme.entity.Ticket;

@ApplicationScoped
public class TicketService {

    @Transactional
    public Ticket createTicket(Ticket ticket) {
        ticket.persist();
        return ticket;
    }

    @Transactional
    public void deleteTicket(Long id) {
        Ticket ticket = Ticket.findById(id);
        if (ticket != null) {
            ticket.delete();
        }
    }

    @Transactional
    public void updateTicket(Long id, Ticket updatedData) {
        Ticket ticket = Ticket.findById(id);
        if (ticket != null) {
            ticket.text = updatedData.text;
            ticket.date = updatedData.date;
        }
    }

    public Ticket getTicket(Long id) {
        return Ticket.findById(id);
    }

    public List<Ticket> getAllTickets() {
        return Ticket.listAll();
    }
}