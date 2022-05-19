package com.movieapp.exception;

import com.movieapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public GlobalExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not Allowed");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Method not Supported");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media Type not supported");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"unsupported media type");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media Type not acceptable");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Unacceptable");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Path variable is missing");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Missing path variable");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Missing servet");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Servlet is missing");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not Allowed");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Method not Supported");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Object> handleMovieNotFound(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Movie not Found");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Movie not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(ShowNotFoundException.class)
    public ResponseEntity<Object> handleShowNotFound(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Show not Found");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Show not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(TheatreNotFoundException.class)
    public ResponseEntity<Object> handleTheatreNotFound(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Theatre not Found");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Theatre not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<Object> handleBookingNotFound(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Booking not Found");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Booking not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFound(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Customer not Found");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Customer is not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>handleOther(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Other Exception");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Movie not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
}
