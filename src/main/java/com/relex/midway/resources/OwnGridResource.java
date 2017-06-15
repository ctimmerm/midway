package com.relex.midway.resources;

import com.relex.midway.BattleshipApplication;
import com.relex.midway.api.Grid;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/own-grid")
@Produces(MediaType.APPLICATION_JSON)
public class OwnGridResource {
    private BattleshipApplication application;

    public OwnGridResource(BattleshipApplication application) {
        this.application = application;
    }

    @GET
    public Grid getGrid() {
        return new Grid(application.getOwnGrid().getGrid());
    }
}
