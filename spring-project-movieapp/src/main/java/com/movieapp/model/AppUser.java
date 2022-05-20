package com.movieapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Column(unique = true,length = 20)
    private String username;
    private String password;
    @Id
    @GeneratedValue
    private  Integer userId;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
