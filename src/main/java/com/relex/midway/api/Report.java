package com.relex.midway.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by omerfurkantercan on 15/06/2017.
 */
public class Report {
    private int turn;
    private Move you;
    private Move enemy;

    public Report(){}

    public Report(int turn, Move you, Move enemy) {
        this.turn = turn;
        this.you = you;
        this.enemy = enemy;
    }
    @JsonProperty
    public int getTurn() {
        return turn;
    }
    @JsonProperty
    public void setTurn(int turn) {
        this.turn = turn;
    }
    @JsonProperty
    public Move getYou() {
        return you;
    }
    @JsonProperty
    public void setYou(Move you) {
        this.you = you;
    }
    @JsonProperty
    public Move getEnemy() {
        return enemy;
    }
    @JsonProperty
    public void setEnemy(Move enemy) {
        this.enemy = enemy;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Report{");
        sb.append("turn=").append(turn);
        sb.append(", you=").append(you);
        sb.append(", enemy=").append(enemy);
        sb.append('}');
        return sb.toString();
    }
}
