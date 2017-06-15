package com.relex.midway.db;

import com.relex.midway.api.Move;

public class GridObject {
    public static final String CELL_SHIP_1 = "1";
    public static final String CELL_SHIP_2 = "2";
    public static final String CELL_SHIP_3 = "3";
    public static final String CELL_SHIP_4 = "4";
    public static final String CELL_SHIP_5 = "5";
    public static final String CELL_UNKNOWN = "?";
    public static final String CELL_HIT = "x";
    public static final String CELL_SUNK = "X";
    public static final String CELL_MISS = "o";
    public static final String CELL_EMPTY = " ";

    final String[][] grid;

    public GridObject(boolean addBattleShips) {
        grid = new String[10][10];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = CELL_EMPTY;
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
                grid[x][y] = CELL_HIT;
                break;
            case Move.MISS:
                grid[x][y] = CELL_MISS;
                break;
            case Move.SUNK:
                grid[x][y] = CELL_SUNK;
                break;
            default:
                break;
        }
    }

    private void addBattleShips() {
        grid[1][0] = CELL_SHIP_1;
        grid[2][0] = CELL_SHIP_1;
        grid[3][0] = CELL_SHIP_1;
        grid[4][0] = CELL_SHIP_1;
        grid[5][0] = CELL_SHIP_1;

        grid[0][5] = CELL_SHIP_2;
        grid[0][6] = CELL_SHIP_2;
        grid[0][7] = CELL_SHIP_2;
        grid[0][8] = CELL_SHIP_2;

        grid[5][4] = CELL_SHIP_3;
        grid[6][4] = CELL_SHIP_3;
        grid[7][4] = CELL_SHIP_3;

        grid[3][9] = CELL_SHIP_4;
        grid[4][9] = CELL_SHIP_4;

        grid[9][1] = CELL_SHIP_5;
        grid[9][2] = CELL_SHIP_5;
    }
}
