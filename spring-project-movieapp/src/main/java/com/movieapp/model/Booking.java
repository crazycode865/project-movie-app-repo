/**
 * @Author:Awadhesh
 * Date:14-05-2022
 * Time:19:04
 * Project Name:project-movie-application
 */
package com.movieapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {
    @Id
    @GeneratedValue(generator = "booking_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_gen",sequenceName = "booking_seq",initialValue = 1,allocationSize = 1)
    private Integer bookingId;
    private LocalDate bookingDate;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String seatType; // FIRST-CLASS,AC-CLASS,BALCONY
    private int totalSeats;
    private double totalCost;
//    @JsonBackReference("bookings")
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private Show show;
    private String bookingStatus;

    public Booking(LocalDate bookingDate, Customer customer, Movie movie, String seatType, int totalSeats, double totalCost, Show show, String bookingStatus) {
        this.bookingDate = bookingDate;
        this.customer = customer;
        this.movie = movie;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.totalCost = totalCost;
        this.show = show;
        this.bookingStatus = bookingStatus;
    }
}
