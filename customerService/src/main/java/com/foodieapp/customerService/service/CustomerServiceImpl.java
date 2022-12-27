package com.foodieapp.customerService.service;

import com.foodieapp.customerService.domain.Address;
import com.foodieapp.customerService.domain.Customer;

import com.foodieapp.customerService.exception.CustomerAlreadyExitsException;
import com.foodieapp.customerService.exception.CustomerNotFoundException;
import com.foodieapp.customerService.proxy.CustomerProxy;
import com.foodieapp.customerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    private CustomerProxy customerProxy;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerProxy customerProxy) {
        this.customerRepository = customerRepository;
        this.customerProxy=customerProxy;
    }

    @Override
    public Customer registerCustomer(Customer customer) throws CustomerAlreadyExitsException {
        if(customerRepository.findById(customer.getEmail()).isPresent()){
            throw new CustomerAlreadyExitsException();
        }
        Customer addCustomer= customerRepository.save(customer);

        if(!(addCustomer.getEmail().isEmpty())){
            ResponseEntity responseEntity = customerProxy.saveCustomer(customer);
            System.out.println(responseEntity.getBody());
        }
        return addCustomer;
    }


//    @Override
//    public Customer addAddressForCustomer(String email, Address address) {
//        Customer customer = customerRepository.findByEmail(email);
//        if(customer.getAddress()==null){
//            customer.setAddress(address);
//        }else {
//            List<Address> addressList=customer.getAddress();
//            addressList.add(address);
//            customer.setAddress(addressList);
//        }
//        return customerRepository.save(customer);
//    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerNotFoundException {

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerRepository.findByEmail(email);
    }


    @Override
    public Customer updateCustomerDetails(Customer customer, String email)  {
        Optional<Customer> optionalCustomer = customerRepository.findById(email);
        if(optionalCustomer.isEmpty()){
            return null;
        }

        Customer existingCustomer = optionalCustomer.get();
        if (customer.getCustomerName()!=null){
            existingCustomer.setCustomerName(customer.getCustomerName());
        }
        if (customer.getPassword()!= null){
            existingCustomer.setPassword(customer.getPassword());
        }
        if (customer.getMobileNo()!=null){
            existingCustomer.setMobileNo(customer.getMobileNo());
        }
        Address exitsaddress = optionalCustomer.get().getAddress();
//        List<Address> exitsaddress = optionalCustomer.get().getAddressList();
//
//        Iterator<Address> iterator =exitsaddress.iterator();
//        while (iterator.hasNext()){
//            Address address =iterator.next();
//            if(address.getHouseNo()==address.getHouseNo()){
//                address.setHouseNo(address.getHouseNo());
//                address.setCity(address.getCity());
//                address.setLandMark(address.getLandMark());
//                address.setZipCode(address.getZipCode());
//            }
//        }
            exitsaddress.setHouseNo(customer.getAddress().getHouseNo());
            exitsaddress.setLandMark(customer.getAddress().getLandMark());
            exitsaddress.setCity(customer.getAddress().getCity());
            exitsaddress.setZipCode(customer.getAddress().getZipCode());

        existingCustomer.setAddress(exitsaddress);
        return customerRepository.save(existingCustomer);
    }

    @Override
    public Address getAddressByEmail(String email) throws CustomerNotFoundException {
        if (customerRepository.findById(email).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerRepository.findById(email).get().getAddress();
    }
}
