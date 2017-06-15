package com.relex.midway.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EndGame {
    private String message;

    public EndGame() {
        // Jackson deserialization
    }

    public EndGame(String message) {
        this.message = message;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

}
