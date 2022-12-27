package com.foodieapp.customerService.controller;

import com.foodieapp.customerService.domain.Customer;
import com.foodieapp.customerService.exception.CustomerAlreadyExitsException;
import com.foodieapp.customerService.exception.CustomerNotFoundException;
import com.foodieapp.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/customerservice/v1")
public class CustomerController {
    private  ResponseEntity responseEntity;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    http://localhost:8081/customerservice/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExitsException {
        Customer customer1 = customerService.registerCustomer(customer);
        return responseEntity=new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    //http://localhost:8081/customerservice/v1/customers/{email}
    @GetMapping("/customers/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try {
            responseEntity = new ResponseEntity<>(customerService.getCustomerByEmail(email),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //http://localhost:8081/customerservice/v1/customers/address/{email}
    @GetMapping("/customers/address/{email}")
    public ResponseEntity<?> getUserAddressByEmail(@PathVariable String email){
        try {
            responseEntity = new ResponseEntity<>(customerService.getAddressByEmail(email),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //http://localhost:8081/customerservice/v1/customers
    @GetMapping("/customers")
    public ResponseEntity<?> getAllUser(){
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //http://localhost:8081/customerservice/v1/customers/update/{email}

    @PutMapping("customers/update/{email}")
    public ResponseEntity<?> updateUser(@RequestBody Customer customer, @PathVariable String email){
            return new ResponseEntity<>(customerService.updateCustomerDetails(customer,email),HttpStatus.CREATED);
    }

}
