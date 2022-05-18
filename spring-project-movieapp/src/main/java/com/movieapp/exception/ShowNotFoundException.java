/**
 * @Author:Awadhesh
 * @Date:15-05-2022
 * @Time:19:52
 * @Project Name:project-movie-application
 */
package com.movieapp.exception;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException() {
    }

    public ShowNotFoundException(String message) {
        super(message);
    }
}
