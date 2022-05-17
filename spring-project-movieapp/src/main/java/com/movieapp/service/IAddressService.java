package com.movieapp.service;

import com.movieapp.model.Address;

public interface IAddressService {
    public void addAddress(Address address);
    public void updateAddress(Address address);
    public  void deleteAddress(int addressId);
    public void getById(int addressId);


}
