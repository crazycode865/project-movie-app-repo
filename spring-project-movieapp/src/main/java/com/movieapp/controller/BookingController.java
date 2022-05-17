/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:14:47
 * @Project Name:project-movie-application
 */
package com.movieapp.controller;

import com.movieapp.model.Booking;
import com.movieapp.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
