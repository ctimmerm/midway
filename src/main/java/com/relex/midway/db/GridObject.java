package com.relex.midway.db;

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
        grid[7][4] = "3";

        // add #4
        grid[3][9] = "4";
        grid[4][9] = "4";

        // add #5
        grid[9][1] = "5";
        grid[9][2] = "5";
    }
}
