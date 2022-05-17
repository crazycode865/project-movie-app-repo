/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:22:48
 * @Project Name:project-movie-application
 */
package com.movieapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppUser {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(unique = true,length = 20)
    private String username;
    private String password;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
