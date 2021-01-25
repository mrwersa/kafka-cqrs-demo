package com.example.common.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Colour {
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    @JsonValue
    public final String label;

    Colour(String label) {
        this.label = label;
    }
}
