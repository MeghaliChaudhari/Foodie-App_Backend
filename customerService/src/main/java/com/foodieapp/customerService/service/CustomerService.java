package com.foodieapp.customerService.service;

import com.foodieapp.customerService.domain.Address;
import com.foodieapp.customerService.domain.Customer;
import com.foodieapp.customerService.exception.CustomerAlreadyExitsException;
import com.foodieapp.customerService.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyExitsException;
    //Customer addAddressForCustomer(String email, Address address) ;
    public List<Customer> getAllCustomers() throws CustomerNotFoundException;

    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException;
    public Customer updateCustomerDetails(Customer customer, String email);
    public Address getAddressByEmail(String email) throws CustomerNotFoundException;
}
