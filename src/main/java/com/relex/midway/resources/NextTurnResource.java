package com.relex.midway.resources;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.relex.midway.api.Report;
import com.relex.midway.api.Target;

@Path("/next_turn")
@Produces(MediaType.APPLICATION_JSON)
public class NextTurnResource {
    @POST
    public Target nextTurn(Report report) {
        System.out.println("next turn endpoint");
        System.out.println(report);
        return new Target(1,1);
    }
}