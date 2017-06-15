package com.relex.midway.api;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Grid {
    private String[][] grid;

    public Grid() {
        // Jackson deserialization
    }

    public Grid(String[][] grid) {
        this.grid = grid;
    }

    @JsonProperty
    public String[][] getGrid() {
        return grid;
    }
}
