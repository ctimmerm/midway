package com.relex.midway.db;

import com.relex.midway.api.Move;

/**
 * Created by andrebrunnsberg on 15.06.17.
 */
public class GridObject {
    final String[][] grid;

    public GridObject(boolean addBattleShips) {
        grid = new String[10][10];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
            }
        }

        if (addBattleShips) {
            addBattleShips();
        }
    }

    public String[][] getGrid() {
        return grid;
    }

    public void updateGrid(Move move) {
        int x = move.getTarget().getX();
        int y = move.getTarget().getY();
        switch (move.getEvent()){
            case Move.HIT:
                grid[x][y] = "x";
                break;
            case Move.MISS:
                grid[x][y] = "o";
                break;
            case Move.SUNK:
                grid[x][y] = "X";
                break;
            default:
                break;
        }
    }

    private void addBattleShips() {
        // add #1
        grid[1][0] = "1";
        grid[2][0] = "1";
        grid[3][0] = "1";
        grid[4][0] = "1";
        grid[5][0] = "1";

        // add #2
        grid[0][5] = "2";
        grid[0][6] = "2";
        grid[0][7] = "2";
        grid[0][8] = "2";

        // add #3
        grid[5][4] = "3";
        grid[6][4] = "3";
        grid[7][4] = "x";

        // add #4
        grid[3][9] = "4";
        grid[4][9] = "4";

        // add #5
        grid[9][1] = "5";
        grid[9][2] = "5";
    }
}
