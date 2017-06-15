package com.relex.midway.resources;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.relex.midway.api.NextTurnRequest;
import com.relex.midway.BattleshipApplication;
import com.relex.midway.api.Report;
import com.relex.midway.api.Target;

@Path("/next_turn")
@Produces(MediaType.APPLICATION_JSON)
public class NextTurnResource {
    private BattleshipApplication application;

    public NextTurnResource(BattleshipApplication application) {
        this.application = application;
    }

    @POST
    public Target nextTurn(NextTurnRequest request) {
        System.out.println("next turn endpoint");
        System.out.println(request);
        return new Target(1,1);
    }
}
