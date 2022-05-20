package com.movieapp.model;

public enum Status {
    BOOKED("Booked"),
    CANCELLED("Cancelled");

    private String type;

    Status(String type) {
        this.type = type;
    }
}
