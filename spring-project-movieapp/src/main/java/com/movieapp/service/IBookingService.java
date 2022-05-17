/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:12:20
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.model.Booking;
import com.movieapp.model.Customer;
import com.movieapp.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface IBookingService {
    public Booking addBooking(Booking booking, Integer customerId,Integer showId);
    public List<Booking> getById(int bookingId);
    public List<Booking> getByBookingDate(LocalDate bookingDate);
    public List<Booking> getByCustomerName(String customerName);
    public List<Booking> getBySeatType(String seatType);
    public List<Booking> getByMovieName(String movieName);
}
