package com.movieapp.model;

public enum Seat {
    FIRST_CLASS("First-Class"),
    SECOND_CLASS("Second-Class"),
    AC_CLASS("AC-Class"),
    BALCONY("Balcony");
    public String type;

    Seat(String type) {
        this.type = type;
    }
}
