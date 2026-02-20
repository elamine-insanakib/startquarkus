package org.acme.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.acme.entity.TicketEntity;
import org.acme.resource.TicketDto;

@ApplicationScoped
public class TicketService {

    @Transactional
    public TicketEntity createTicket(TicketDto ticket) {
        TicketEntity ticketEntity = new TicketEntity(ticket.getText(), LocalDateTime.now());
        ticketEntity.persist();
        return ticketEntity;
    }

    @Transactional
    public void deleteTicket(Long id) {
        TicketEntity ticket = TicketEntity.findById(id);
        if (ticket != null) {
            ticket.delete();
        }
    }

    @Transactional
    public void updateTicket(Long id, TicketDto ticketHttp) {
        TicketEntity ticketBdd = TicketEntity.findById(id);
        if (ticketBdd != null) {
            ticketBdd.setDate(LocalDateTime.now());
            ticketBdd.setText(ticketHttp.getText());
        }
    }

    public TicketDto getTicket(Long id) {
        TicketEntity byId = TicketEntity.findById(id);
        return new TicketDto(byId.getText());
    }



    public List<TicketEntity> getAllTickets() {
        return TicketEntity.listAll();
    }
}