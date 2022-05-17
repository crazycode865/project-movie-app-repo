/**
 * @Author:Awadhesh
 * Date:14-05-2022
 * Time:14:55
 * Project Name:project-movie-application
 */
package com.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(generator = "show_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "show_gen",sequenceName = "show_seq",initialValue = 1,allocationSize = 1)
    private Integer showId;
    @Column(length = 20)
    private String showName;
    private double price;
    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;
//    @ManyToOne(cascade = CascadeType.MERGE)
//    private Set<Theatre> theatre ;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    //@JsonIgnore
    private Movie movie;
//    @JsonIgnore
//    @ToExclude
    @OneToOne
@JoinColumn(name = "booing_id")
       private Booking booking;

    public Show(String showName, double price, LocalDateTime showStartTime, LocalDateTime showEndTime, Movie movie, Booking booking) {
        this.showName = showName;
        this.price = price;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.movie = movie;
        this.booking = booking;
    }
}
