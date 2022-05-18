/**
 * @Author:Awadhesh
 * Date:14-05-2022
 * Time:22:28
 * Project Name:project-movie-application
 */
package com.movieapp.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
    }
}
