package com.relex.midway.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Grid {
    private long id;

    @Length(max = 3)
    private String content;

    public Grid() {
        // Jackson deserialization
    }

    public Grid(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
