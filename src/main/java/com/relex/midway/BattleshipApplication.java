package com.relex.midway;

import com.relex.midway.db.GridObject;
import com.relex.midway.resources.NextTurnResource;
import com.relex.midway.resources.EndGameResource;
import com.relex.midway.resources.EnemyGridResource;
import com.relex.midway.resources.OwnGridResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BattleshipApplication extends Application<BattleshipConfiguration> {

    private GridObject ownGrid = new GridObject(true);
    private GridObject enemyGrid = new GridObject(false);

    public static void main(final String[] args) throws Exception {
        new BattleshipApplication().run(args);
    }

    @Override
    public String getName() {
        return "battleship";
    }

    @Override
    public void initialize(final Bootstrap<BattleshipConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final BattleshipConfiguration configuration,
                    final Environment environment) {

        final NextTurnResource nextResource = new NextTurnResource(this);
        environment.jersey().register(nextResource);

        final OwnGridResource ownGridResource = new OwnGridResource(this);
        environment.jersey().register(ownGridResource);

        final EnemyGridResource enemyGridResource = new EnemyGridResource(this);
        environment.jersey().register(enemyGridResource);

        final EndGameResource endGameResource = new EndGameResource(this);
        environment.jersey().register(endGameResource);
    }

    public GridObject getOwnGrid() {
        return ownGrid;
    }

    public GridObject getEnemyGrid() {
        return enemyGrid;
    }
}
