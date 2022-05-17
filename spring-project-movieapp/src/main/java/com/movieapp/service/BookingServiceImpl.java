/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:12:42
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.model.*;
import com.movieapp.repository.IBookingRepository;
import com.movieapp.repository.ICustomerRepository;
import com.movieapp.repository.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {
    IBookingRepository iBookingRepository;
    IShowRepository iShowRepository;
    ICustomerRepository iCustomerRepository;

    @Autowired
    public void setiCustomerRepository(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Autowired
    public void setiShowRepository(IShowRepository iShowRepository) {
        this.iShowRepository = iShowRepository;
    }

    @Autowired
    public void setiBookingRepository(IBookingRepository iBookingRepository) {
        this.iBookingRepository = iBookingRepository;
    }


    @Override
    public Booking addBooking(Booking booking, Integer customerId, Integer showId) {
        Customer customer = new Customer();
        Show show = new Show();
        if (showId != null) {
         show =  iShowRepository.getById(showId);
            double price = show.getPrice();
            booking.setTotalCost(price*booking.getTotalSeats());
            show.setBooking(booking);
            booking.setShow(show);
            booking.setMovie(show.getMovie());
            customer = iCustomerRepository.getById(customerId);
            booking.setCustomer(customer);
        }
        iBookingRepository.save(booking);
        return iBookingRepository.findById(booking.getBookingId()).get();
    }

    @Override
    public List<Booking> getById(int bookingId) {
        return iBookingRepository.getByBookingId(bookingId);
    }

    @Override
    public List<Booking> getByBookingDate(LocalDate bookingDate) {
        return iBookingRepository.getByBookingDate(bookingDate);
    }

    @Override
    public List<Booking> getByCustomerName(String customerName) {
        return iBookingRepository.getByCustomerName(customerName);
    }

    @Override
    public List<Booking> getBySeatType(String seatType) {
        return iBookingRepository.getBySeatType(seatType);
    }

    @Override
    public List<Booking> getByMovieName(String movieName) {
        return iBookingRepository.getByMovieName(movieName);
    }
}
