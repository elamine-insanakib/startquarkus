package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/world")
public class WorldResource {

    @ConfigProperty(name = "greeting")
    String greeting;

    @ConfigProperty(name = "complete")
    String complete;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String world() {
        return greeting + complete;
    }

    @GET
    @Path("/other")
    @Produces(MediaType.TEXT_PLAIN)

    public String Negative() {
        return "A world isn't possible...";
    }
}