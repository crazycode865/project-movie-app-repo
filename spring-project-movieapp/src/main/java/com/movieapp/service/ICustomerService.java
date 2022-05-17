package com.movieapp.service;

import com.movieapp.model.Customer;

public interface ICustomerService {
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int customerId);
    public void getById(int customerId);


}
