/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:15:47
 * @Project Name:project-movie-application
 */
package com.movieapp.controller;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Customer;
import com.movieapp.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {
    ICustomerService iCustomerService;

    @Autowired
    public void setiCustomerService(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }
    @PostMapping("/customers")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer){
        iCustomerService.addCustomer(customer);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }
    @PutMapping("/customers")
    public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer){
        iCustomerService.updateCustomer(customer);
        ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }
    @DeleteMapping("/customers/customerId/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId")int customerId){
        iCustomerService.deleteCustomer(customerId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Deleting By Id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }
    @GetMapping("/customers/showAll")
    public ResponseEntity<List<Customer>> getall() throws MovieNotFoundException {
        List<Customer> customers = iCustomerService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "Getting all movies");
        ResponseEntity<List<Customer>> responseEntity = new ResponseEntity<>(customers, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
}
