package com.relex.midway.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by omerfurkantercan on 15/06/2017.
 */
public class Target {
    private int x;
    private int y;

    public Target(){}

    public Target(int x, int y){
        this.x = x;
        this.y = y;
    }
    @JsonProperty
    public int getX() {
        return x;
    }
    @JsonProperty
    public void setX(int x) {
        this.x = x;
    }
    @JsonProperty
    public int getY() {
        return y;
    }
    @JsonProperty
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Target{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
