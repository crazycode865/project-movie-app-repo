/**
 * @Author:Awadhesh
 * @Date:19-05-2022
 * @Time:01:55
 * @Project Name:project-movie-application
 */
package com.movieapp.exception;

public class BookingNotFoundException  extends RuntimeException{
    public BookingNotFoundException() {
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}
