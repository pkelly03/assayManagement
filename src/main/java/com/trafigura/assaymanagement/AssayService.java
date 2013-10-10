package com.trafigura.assaymanagement;

import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/assays")
public class AssayService {

    private Integer assayId = new Integer(0);

	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Response savePayment() throws Exception {
        return Response.created(new URI(assayId.toString())).entity("{\"id\":" + ++assayId + "}").build();
	}

}