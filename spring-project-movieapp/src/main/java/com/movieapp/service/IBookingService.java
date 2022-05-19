/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:12:20
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.exception.BookingNotFoundException;
import com.movieapp.model.Booking;
import com.movieapp.model.Customer;
import com.movieapp.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface IBookingService {
    public Booking addBooking(Booking booking, Integer customerId,Integer showId);
    public  void deleteBooking(Integer bookingId);
    public void  cancelBooking(int bookingId);
    public Booking getByBookingId(int bookingId)throws BookingNotFoundException;
    public List<Booking> getByBookingDate(LocalDate bookingDate)throws BookingNotFoundException;


    public List<Booking> getByCustomerName(String customerName)throws BookingNotFoundException;
    public List<Booking> getBySeatType(String seatType)throws BookingNotFoundException;
    public List<Booking> getByMovieName(String movieName)throws BookingNotFoundException;
    public List<Booking> getByShowName(String showName)throws BookingNotFoundException;
    public List<Booking> getByMovieLanguage(String language)throws BookingNotFoundException;
    List<Booking> getAll()throws BookingNotFoundException;

    double getSumOfBookingCost();

    int totalNumberOfBooking();


    int totalNumberOfCancelledBooking();
}
