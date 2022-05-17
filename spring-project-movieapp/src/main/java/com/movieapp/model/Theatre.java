/**
 * @Author:Awadhesh
 * Date:14-05-2022
 * Time:18:54
 * Project Name:project-movie-application
 */
package com.movieapp.model;



import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(generator = "theatre_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "theater_gen",sequenceName = "theatre_seq",initialValue = 100,allocationSize = 1)
    @ToString.Exclude
    private Integer theatreId;
    @Column(length = 20)
    private String theatreName;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address  address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @ToString.Exclude
    @JoinColumn(name = "theatre_id")
    private Set<Show> shows;

    public Theatre(String theatreName, Address address) {
        this.theatreName = theatreName;
        this.address = address;
        //this.shows = shows;
    }
}
