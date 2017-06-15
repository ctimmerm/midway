package com.relex.midway.resources;


import java.util.Random;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.relex.midway.BattleshipApplication;
import com.relex.midway.api.Move;
import com.relex.midway.api.NextTurnRequest;
import com.relex.midway.api.Target;
import com.relex.midway.db.GridObject;

@Path("/next_turn")
@Produces(MediaType.APPLICATION_JSON)
public class NextTurnResource {
    private BattleshipApplication application;

    boolean wasPreviousHit = false;
    int previousX;
    int previousY;

    public NextTurnResource(BattleshipApplication application) {
        this.application = application;
    }

    @POST
    public Target nextTurn(NextTurnRequest request) {
        String[][] enemyGrid = application.getEnemyGrid().getGrid();

        if (request != null && request.getReport().getYou() != null) {
            if (request.getReport().getYou().getEvent().equals("HIT")) {
                wasPreviousHit = true;
                enemyGrid[previousX][previousY] = GridObject.CELL_HIT;
            } else if (request.getReport().getYou().getEvent().equals("SUNK")) {
                wasPreviousHit = false;
                enemyGrid[previousX][previousY] = GridObject.CELL_SUNK;
            } else {
                wasPreviousHit = false;
                enemyGrid[previousX][previousY] = GridObject.CELL_MISS;
            }
        } else {
            wasPreviousHit = false;
            enemyGrid[previousX][previousY] = GridObject.CELL_MISS;
        }

        if (request != null && request.getReport() != null && request.getReport().getEnemy() != null) {

            System.out.println("next turn endpoint");
            application.getOwnGrid().updateGrid(request.getReport().getEnemy());
        }

        return fireMissile();
    }

    private Target fireMissile() {
        Random random = new Random();
        String[][] enemyGrid = application.getEnemyGrid().getGrid();

        if (wasPreviousHit) {
            // try to make a X-scale +/-1 firew
            if (previousX > 0 && previousX < 9) {
                int randomX = previousX + (random.nextBoolean() ? +1 : -1);
                int randomY = previousY;
                if (enemyGrid[randomX][randomY].equals(GridObject.CELL_EMPTY)) {
                    previousX = randomX;
                    previousY = randomY;

                    wasPreviousHit = false;
                    return new Target(previousX, previousY);
                }
            }
            // try to make a Y-scale +/-1 firew
            if (previousY > 0 && previousY < 9) {
                int randomY = previousY + (random.nextBoolean() ? +1 : -1);
                int randomX = previousX;
                if (enemyGrid[randomX][randomY].equals(GridObject.CELL_EMPTY)) {
                    previousX = randomX;
                    previousY = randomY;

                    wasPreviousHit = false;
                    return new Target(previousX, previousY);
                }
            }
        }

        while (true) {
            int randomX = random.nextInt(10);
            int randomY = random.nextInt(10);

            if (enemyGrid[randomX][randomY].equals(GridObject.CELL_EMPTY)) {
                enemyGrid[randomX][randomY] = GridObject.CELL_UNKNOWN;
                previousX = randomX;
                previousY = randomY;

                wasPreviousHit = false;
                return new Target(previousX, previousY);
            }
        }
    }

    public void updateOwnGrid(Move enemyMove) {
    }
}
