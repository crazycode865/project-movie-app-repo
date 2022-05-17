package com.movieapp.repository;

import com.movieapp.model.Booking;
import com.movieapp.model.Customer;
import com.movieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer> {
    @Query("from Booking b where b.bookingId=?1")
    public List<Booking> getByBookingId(int bookingId);
    @Query("from Booking b where b.bookingDate=?1")
    public List<Booking> getByBookingDate(LocalDate bookingDate);
    @Query("from Booking b inner join b.customer c where c.customerName=?1")
    public List<Booking> getByCustomerName(String customerName);
    @Query("from Booking b where b.seatType=?1")
    public List<Booking> getBySeatType(String seatType);
    @Query("from Booking b inner join b.movie m where m.movieName=?1 ")
    public List<Booking> getByMovieName(String movieName);
}
