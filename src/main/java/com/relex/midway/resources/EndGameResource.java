package com.relex.midway.resources;

import com.relex.midway.api.EndGame;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Map;

@Path("/end_game")
@Produces(MediaType.APPLICATION_JSON)
public class EndGameResource {

    public EndGameResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public EndGame getGrid(Map<String,Object> params) {

        String result = (String)params.getOrDefault("Result", "LOSE");
        String message = result.equals("LOSE") ? "AAAGH!" : "Im invincible!";

        return new EndGame(message);
    }
}
