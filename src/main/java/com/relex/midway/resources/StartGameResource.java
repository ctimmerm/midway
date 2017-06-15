package com.relex.midway.resources;


import com.relex.midway.BattleshipApplication;
import com.relex.midway.api.Grid;
import com.relex.midway.db.GridObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/start_game")
@Produces(MediaType.APPLICATION_JSON)
public class StartGameResource {
    private BattleshipApplication application;

    public StartGameResource(BattleshipApplication application) {
        this.application = application;
    }

    @GET
    public Grid getGrid() {
        GridObject ownGrid = new GridObject(true);
        GridObject enemyGrid = new GridObject(false);

        application.setOwnGrid(ownGrid);
        application.setEnemyGrid(enemyGrid);

        return new Grid(application.getOwnGrid().getGrid());
    }
}
