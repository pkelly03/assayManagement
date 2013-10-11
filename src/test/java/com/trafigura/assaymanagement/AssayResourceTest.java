package com.trafigura.assaymanagement;


import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.inmemory.InMemoryTestContainerFactory;
import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;

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
}
