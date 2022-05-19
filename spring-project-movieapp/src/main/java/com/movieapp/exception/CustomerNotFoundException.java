/**
 * @Author:Awadhesh
 * @Date:19-05-2022
 * @Time:03:31
 * @Project Name:project-movie-application
 */
package com.movieapp.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
