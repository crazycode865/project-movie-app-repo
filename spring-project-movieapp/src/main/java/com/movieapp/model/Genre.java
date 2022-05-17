package com.movieapp.model;

public enum Genre {
    ACTION("Action"),DRAMA("Drama"),
    ROMANCE("Romance"),COMEDY("Comedy"),
    CRIME("Crime"), THRILLER("Thriller"),
    ADVENTURE("Adventure"),HORROR("Horror"),
    SCI_FI("Sci-fi"),SPORTS("Sports"),
    FAMILY("Family");
   public String type;
    Genre(String type) {
        this.type = type;
    }
}
