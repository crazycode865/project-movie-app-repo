package com.movieapp.repository;

import com.movieapp.exception.BookingNotFoundException;
import com.movieapp.model.Booking;
import com.movieapp.model.Customer;
import com.movieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {


    //Derived Query

    public List<Booking> getByBookingId(int bookingId);

    //Getting Type conversion error
    public List<Booking> getByBookingDate(LocalDate bookingDate);

    public List<Booking> getBySeatType(String seatType);


    //Custom Query
    @Query("from Booking b inner join b.movie m where m.movieName=?1")
    public List<Booking> getByMovieName(String movieName);

    @Query("from Booking b inner join b.show s where s.showName=?1")
    public List<Booking> getByShowName(String showName);

    @Query("from Booking b inner join b.customer c where c.customerName=?1")
    public List<Booking> getByCustomerName(String customerName);

    @Query("from Booking b inner join b.movie m where m.language=?1")
    public List<Booking> getByMovieLanguage(String language);

    @Query("from Booking b inner join b.customer c where c.emailId=?1")
    public List<Booking> getByCustomerEmail(String emailId);


    //Native query
    @Query(value = "select sum(total_cost) from booking", nativeQuery = true)
    double getSumOfBookingCost();

    @Query(value = "select count(booking_id) from booking where booking_status='BOOKED'", nativeQuery = true)
    int totalNumberOfBooking();

    @Query(value = "select count(booking_id) from booking where booking_status='CANCELLED'",nativeQuery = true)
    int totalNumberOfCancelledBooking();

    @Query(value = "update booking set booking_status='CANCELLED' where booking_id=bookingId",nativeQuery = true)
    public void cancelBooking(int bookingId);


}
