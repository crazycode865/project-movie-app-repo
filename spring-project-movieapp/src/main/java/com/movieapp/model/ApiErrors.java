package com.movieapp.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiErrors {
    LocalDateTime timestamp;
    HttpStatus status;
    int statusCode;
    String error;
    List<String> message;

}
