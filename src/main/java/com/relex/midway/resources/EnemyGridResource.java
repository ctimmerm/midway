package com.relex.midway.resources;

import com.relex.midway.api.Grid;
import com.codahale.metrics.annotation.Timed;
import com.relex.midway.db.GridObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/api/enemy-grid")
@Produces(MediaType.APPLICATION_JSON)
public class EnemyGridResource {
    private final AtomicLong counter;

    public EnemyGridResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Grid getGrid(@QueryParam("name") Optional<String> name) {
        final String value = name.orElse("empty");

        GridObject ownGrid = new GridObject(false);

        return new Grid(ownGrid.getGrid());
    }
}