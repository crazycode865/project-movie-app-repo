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

    /**
     *
     * @param booking
     * @param customerId
     * @param showId
     * @return Adding Booking By Passing Customer Id and Show id
     */
    @PostMapping("/booking/customerId/{customerId}/showId/{showId}")
    public ResponseEntity<Void> addBooking(@RequestBody Booking booking,@PathVariable("customerId") Integer customerId,@PathVariable("showId") Integer showId){

        iBookingService.addBooking(booking,customerId,showId);

        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
}
    @DeleteMapping("/booking/delete/bookingId/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("bookingId") int bookingId){

        iBookingService.deleteBooking(bookingId);

        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }
   @PutMapping("/booking/cancel/bookingId/{bookingId}")
   public ResponseEntity<Void> cancelBooking(@PathVariable("bookingId") int bookingId){

       iBookingService.cancelBooking(bookingId);

       ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).build();
       return responseEntity;
   }

    /**
     *
     * @param bookingId
     * @return Show Booking By Id
     */
    @GetMapping("/booking/bookingId/{bookingId}")
    public ResponseEntity<Booking> getById(@PathVariable("bookingId")int bookingId) throws MovieNotFoundException {
        Booking booking = iBookingService.getByBookingId(bookingId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings BY Id");
        ResponseEntity <Booking> responseEntity = new ResponseEntity<>(booking, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @return Show All Booking
     */
    @GetMapping("/booking/showAll")
    public ResponseEntity<List<Booking>> getAll()  {
        List<Booking> bookings = iBookingService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @param seatType
     * @return Show All Booking by Seat Type
     */
    @GetMapping("/booking/seatType/{seatType}")
    public ResponseEntity<List<Booking>> getBySeatType(@PathVariable("seatType")String seatType) {
        List<Booking> bookings = iBookingService.getBySeatType(seatType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings by Seat Type");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @param bookingDate
     * @return Show All Booking with this Date
     */
    @GetMapping("/booking/bookingDate/{bookingDate}")
    public ResponseEntity<List<Booking>> getByBookingDate(@PathVariable("bookingDate") String bookingDate) {
        LocalDate bkingDate = LocalDate.parse(bookingDate);
        List<Booking> bookings = iBookingService.getByBookingDate(bkingDate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings by Booking Date");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @param customerName
     * @return Show All Booking By Customer Name
     */
    @GetMapping("/booking/customerName/{customerName}")
    public ResponseEntity<List<Booking>> getByCustomerName(@PathVariable(
            "customerName")String customerName)  {
        List<Booking> bookings = iBookingService.getByCustomerName(customerName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @param movieName
     * @return  Show All Booking  By Movie Name
     */
    @GetMapping("/booking/movieName/{movieName}")
    public ResponseEntity<List<Booking>> getByMovieName(@PathVariable("movieName")String movieName){
        List<Booking> bookings = iBookingService.getByMovieName(movieName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @param showName
     * @return Show All Booking By Show Name
     */
    @GetMapping("/booking/showName/{showName}")
    public ResponseEntity<List<Booking>> getByShowName(@PathVariable("showName")String showName){
        List<Booking> bookings = iBookingService.getByShowName(showName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @param language
     * @return Show All Booking By language
     */
    @GetMapping("/booking/language/{language}")
    public ResponseEntity<List<Booking>> getByMovieLanguage(@PathVariable("language")String language){
        List<Booking> bookings = iBookingService.getByMovieLanguage(language);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <List<Booking>> responseEntity = new ResponseEntity<>(bookings, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @return Getting total sum of the booking done
     */
    @GetMapping("/booking/totalCost")
    public ResponseEntity<Integer> getTotalCost(){
        double totalCost = iBookingService.getSumOfBookingCost();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <Integer> responseEntity = new ResponseEntity("Total Sum of Cost: "+totalCost, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     *
     * @return Getting Total Number of Booking done
     */
    @GetMapping("/booking/totalBooking")
    public ResponseEntity<Integer> totalNumberOfBooking(){
        double totalBooking = iBookingService.totalNumberOfBooking();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <Integer> responseEntity = new ResponseEntity("Total Booking: "+totalBooking, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/booking/cancelBooking")
    public ResponseEntity<Integer> totalNumberOfCancelledBooking(){
        int  totalBooking = iBookingService.totalNumberOfCancelledBooking();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting Bookings");
        ResponseEntity <Integer> responseEntity = new ResponseEntity("Total Cancelled Booking: "+totalBooking, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }



}