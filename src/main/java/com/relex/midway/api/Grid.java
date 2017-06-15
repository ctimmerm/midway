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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Grid{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
