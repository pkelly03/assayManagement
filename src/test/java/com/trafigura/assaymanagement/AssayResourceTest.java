package com.trafigura.assaymanagement;


import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AssayResourceTest extends JerseyTest {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder(AssayResource.class.getPackage().getName()).build();
    }

    @Test
    public void createAssay_shouldCreateAnAssay_givenValidEntry() {
        ClientResponse response = resource().path("assays").post(ClientResponse.class);

        assertEquals(response.getStatus(), 201);
        assertTrue(response.getHeaders().getFirst("Location").endsWith("/assays/1"));
    }

    @Test
    public void getAssay_shouldRetrieveAnAssay_givenAValidAssayId() {
        ClientResponse response = resource().path("assays").path("1").get(ClientResponse.class);

        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

//        assertEquals(response.getStatus(), 201);
//        assertTrue(response.getHeaders().getFirst("Location").endsWith("/assays/1"));
    }


}
