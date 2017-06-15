package com.relex.midway.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by omerfurkantercan on 15/06/2017.
 */
public class Move {
    public static final String MISS = "MISS";
    public static final String HIT = "HIT";
    public static final String SUNK = "SUNK";

    private Target target;
    private String event;
    private int ship;
    private String message;

    public Move(){}

    public Move(Target target, String event, int ship, String message) {
        this.target = target;
        this.event = event;
        this.ship = ship;
        this.message = message;
    }
    @JsonProperty
    public Target getTarget() {
        return target;
    }
    @JsonProperty
    public void setTarget(Target target) {
        this.target = target;
    }
    @JsonProperty
    public String getEvent() {
        return event;
    }
    @JsonProperty
    public void setEvent(String event) {
        this.event = event;
    }
    @JsonProperty
    public int getShip() {
        return ship;
    }
    @JsonProperty
    public void setShip(int ship) {
        this.ship = ship;
    }
    @JsonProperty
    public String getMessage() {
        return message;
    }
    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }
}
