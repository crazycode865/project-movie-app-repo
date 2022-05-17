/**
 * @Author:Awadhesh
 * @Date:16-05-2022
 * @Time:15:41
 * @Project Name:project-movie-application
 */
package com.movieapp.service;

import com.movieapp.model.Customer;
import com.movieapp.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepository iCustomerRepository;

    @Autowired
    public void setiCustomerRepository(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public void addCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    /**
     *
     * @param customerId
     */
    @Override
    public void deleteCustomer(int customerId) {
        iCustomerRepository.deleteById(customerId);
    }

    /**
     *
     * @param customerId
     */
    @Override
    public void getById(int customerId) {
        iCustomerRepository.findById(customerId);
    }
}
