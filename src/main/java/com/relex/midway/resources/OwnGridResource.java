package com.relex.midway.resources;

import com.relex.midway.api.Grid;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/own-grid")
@Produces(MediaType.APPLICATION_JSON)
public class OwnGridResource {
    private final AtomicLong counter;

    public OwnGridResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Grid sayHello(@QueryParam("name") Optional<String> name) {
        final String value = name.orElse("empty");
        return new Grid(counter.incrementAndGet(), value);
    }
}