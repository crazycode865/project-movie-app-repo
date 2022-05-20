/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:12:42
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.exception.BookingNotFoundException;
import com.movieapp.model.*;
import com.movieapp.repository.IBookingRepository;
import com.movieapp.repository.ICustomerRepository;
import com.movieapp.repository.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Service

public class BookingServiceImpl implements IBookingService, Serializable {

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

//Adding Booking By passing Customer Id  and Show Id

    /**
     * @param booking
     * @param customerId
     * @param showId
     */
    @Override
    public Booking addBooking(Booking booking, Integer customerId, Integer showId) {
        Customer customer = new Customer();
        Show show = new Show();
        if (showId != null) {
            show = iShowRepository.getById(showId);
            double price = show.getPrice();
            booking.setTotalCost(price * booking.getTotalSeats());
            show.setBooking(booking);
            booking.setShow(show);
            booking.setBookingStatus("BOOKED");
            booking.setMovie(show.getMovie());
            customer = iCustomerRepository.getById(customerId);
            booking.setCustomer(customer);
        }
        iBookingRepository.save(booking);
        return iBookingRepository.findById(booking.getBookingId()).get();
    }

    /**
     *
     * @param bookingId
     * @return Delete Booking
     */
    @Override
    public void deleteBooking(Integer bookingId) {
        iBookingRepository.deleteById(bookingId);
    }

    /**
     * @return Cancelling Booking and setting booking status to CANCELLED
     * @param bookingId
     */
    @Override
    public void cancelBooking(int bookingId) {
        Booking booking = iBookingRepository.getById(bookingId);
        if(!booking.getBookingStatus().equalsIgnoreCase("CANCELLED"))
        booking.setBookingStatus("CANCELLED");
        iBookingRepository.save(booking);
    }
    //Derived query
    //Getting Booking By Id

    /**
     * @param bookingId
     * @throws BookingNotFoundException
     */
    @Override
    public Booking getByBookingId(int bookingId) {

        return iBookingRepository.getByBookingId(bookingId).stream().findAny().orElseThrow(() -> new BookingNotFoundException("Booking not Found with this Id"));
    }

    @Override
    public List<Booking> getAll() {

        return iBookingRepository.findAll();
    }


    //Getting Booking By Booking Date

    /**
     * @param bookingDate
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByBookingDate(LocalDate bookingDate) {
        List<Booking> bookings = iBookingRepository.getByBookingDate(bookingDate);
        if (bookings.isEmpty())
            throw new BookingNotFoundException("Booking with Date not exist");
        return bookings;
    }


    //Custom query
    //Getting Booking By Customer Name

    /**
     * @param customerName
     * @throws BookingNotFoundException
     */

    @Override
    public List<Booking> getByCustomerName(String customerName) {
        List<Booking> bookings = iBookingRepository.getByCustomerName(customerName);
        if (bookings.isEmpty())
            throw new BookingNotFoundException("Booking with this Customer not Found");
        return bookings;
    }

    //Getting Booking By Seat Type

    /**
     * @param seatType
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getBySeatType(String seatType) {

        List<Booking> bookings = iBookingRepository.getBySeatType(seatType);
        if (bookings.isEmpty())
            throw new BookingNotFoundException("Booking with this Seat Type not Found");
        return bookings;
    }

    //Getting Booking By Movie Name

    /**
     * @param movieName
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByMovieName(String movieName) {

        List<Booking> bookings = iBookingRepository.getByMovieName(movieName);
        if (bookings.isEmpty())
            throw new BookingNotFoundException("Booking with this Movie Name not Found");
        return bookings;
    }

    //Getting Booking By Show name

    /**
     * @param showName
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByShowName(String showName) {

        List<Booking> bookings = iBookingRepository.getByShowName(showName);
        if (bookings.isEmpty())
            throw new BookingNotFoundException("Booking with this Show Name not Found");
        return bookings;
    }

    //Getting Booking by language

    /**
     * @param language
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByMovieLanguage(String language) {
        List<Booking> bookings = iBookingRepository.getByMovieLanguage(language);
        if (bookings.isEmpty())
            throw new BookingNotFoundException("Booking with this language not Found");
        return bookings;
    }

    /**
     *
     * @param email
     * @return Getting Booking By customer Email
     */
    @Override
    public List<Booking> getByCustomerEmail(String email) {
        List<Booking> bookings = iBookingRepository.getByCustomerEmail(email);
        if (bookings.isEmpty())
            throw new BookingNotFoundException("Booking with this language not Found");
        return bookings;
    }

    /**
     * @return Getting Total sum of Booking
     */
    @Override
    public double getSumOfBookingCost() {
        return iBookingRepository.getSumOfBookingCost();
    }

    /**
     *
     * @return Getting Total number of Booking done
     */
    @Override
    public int totalNumberOfBooking() {
        return iBookingRepository.totalNumberOfBooking();
    }

    /**
     *
     * @return Getting Total number of CANCELLED booking
     */
    @Override
    public int totalNumberOfCancelledBooking() {
        return iBookingRepository.totalNumberOfCancelledBooking();
    }

}
