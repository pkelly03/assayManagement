package com.trafigura.assaymanagement;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Component
@Path("/assays")
public class AssayResource {

    private Integer assayId = 0;

	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAssay() throws Exception {
        assayId++;
        return Response.created(new URI(assayId.toString())).entity("{\"id\":" + assayId + "}").build();
	}

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{assayId}")
    public Response getAssay(@PathParam(value = "assayId") String assayId) throws Exception {
        return Response.ok().entity("{\"id\":" + assayId + "}").build();
	}

}