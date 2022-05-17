/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:10:25
 * @Project Name:project-movie-application
 */
package com.movieapp.exception;

public class TheatreNotFoundException extends Exception {
    public TheatreNotFoundException() {
    }

    public TheatreNotFoundException(String message) {
        super(message);
    }
}
