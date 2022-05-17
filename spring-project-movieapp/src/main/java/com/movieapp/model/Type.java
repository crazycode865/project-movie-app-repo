package com.movieapp.model;

public enum Type {
    BOLLYWOOD("Bollywood"),
    HOLLYWOOD("Hollywood"),
    KOLLYWOOD("Kollywood");

    private String types;

    Type(String types) {
        this.types = types;
    }
}
