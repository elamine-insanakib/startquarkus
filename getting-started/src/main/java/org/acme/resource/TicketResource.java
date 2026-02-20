package org.acme;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;

import org.acme.entity.TicketEntity;
import org.acme.resource.TicketDto;
import org.acme.service.TicketService;

@Path("/tickets")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TicketResource {

    @Inject
    TicketService ticketService; // Injection du service

    @GET
    public List<TicketEntity> getTickets() {
        return ticketService.getAllTickets(); // Récupère tous les tickets depuis le service
    }

    @GET
    @Path("/{id}")
    public TicketDto getTicket(@PathParam("id") Long id) {
        return ticketService.getTicket(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTicket(@PathParam("id") Long id, TicketDto ticket) {
        ticketService.updateTicket(id, ticket);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTicket(@PathParam("id") Long id) {
        ticketService.deleteTicket(id);
        return Response.status(204).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTicket(TicketDto ticket) {
        ticketService.createTicket(ticket); // Crée un ticket en base
        return Response.status(201).entity(ticket).build(); // Retourne 201 Created
    }
}