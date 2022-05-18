/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:14:47
 * @Project Name:project-movie-application
 */
package com.movieapp.controller;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Booking;
import com.movieapp.model.Movie;
import com.movieapp.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking-api")
public class BookingController {
    IBookingService iBookingService;
    @Autowired
    public void setiBookingService(IBookingService iBookingService) {
        this.iBookingService = iBookingService;
    }
@PostMapping("/booking/customerId/{customerId}/showId/{showId}")
    public ResponseEntity<Void> addBooking(@RequestBody Booking booking,@PathVariable("customerId") Integer customerId,@PathVariable("showId") Integer showId){

        iBookingService.addBooking(booking,customerId,showId);

        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
}

    @GetMapping("/booking/bookingId/{bookingId}")
    public ResponseEntity<List<Booking>> getById(@PathVariable("bookingId")int bookingId) throws MovieNotFoundException {
        List<Booking> bookings = iBookingService.getByBookingId(bookingId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings BY Id");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    //Show All Booking
    @GetMapping("/booking/showAll")
    public ResponseEntity<List<Booking>> getAll() throws MovieNotFoundException {
        List<Booking> bookings = iBookingService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    //Show
    @GetMapping("/booking/seatType/{seatType}")
    public ResponseEntity<List<Booking>> getBySeatType(@PathVariable("seatType")String seatType) throws MovieNotFoundException {
        List<Booking> bookings = iBookingService.getBySeatType(seatType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings by Seat Type");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }


    // Type conversion is coming for date

    @GetMapping("/booking/bookingDate/{bookingDate}")
    public ResponseEntity<List<Booking>> getByBookingDate(@PathVariable("bookingDate") String bookingDate) throws MovieNotFoundException {
        LocalDate bkingDate = LocalDate.parse(bookingDate);
        List<Booking> bookings = iBookingService.getByBookingDate(bkingDate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings by Booking Date");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/booking/customerName/{customerName}")
    public ResponseEntity<List<Booking>> getByCustomerName(@PathVariable(
            "customerName")String customerName) throws MovieNotFoundException {
        List<Booking> bookings = iBookingService.getByCustomerName(customerName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/booking/movieName/{movieName}")
    public ResponseEntity<List<Booking>> getByMovieName(@PathVariable("movieName")String movieName) throws MovieNotFoundException {
        List<Booking> bookings = iBookingService.getByMovieName(movieName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/booking/showName/{showName}")
    public ResponseEntity<List<Booking>> getByShowName(@PathVariable("showName")String showName) throws MovieNotFoundException {
        List<Booking> bookings = iBookingService.getByShowName(showName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/booking/language/{language}")
    public ResponseEntity<List<Booking>> getByMovieLanguage(@PathVariable("language")String language) throws MovieNotFoundException {
        List<Booking> bookings = iBookingService.getByMovieLanguage(language);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }




}
