/**
 * @Author:Awadhesh Date:14-05-2022
 * Time:19:12
 * Project Name:project-movie-application
 */
package com.movieapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
    private Integer addressId;
    @Column(length = 20)
    private String city;
    @Column(length = 20)
    private String state;
    private int zipcode;

    public Address(String city, String state, int zipcode) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
