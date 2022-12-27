package com.foodieapp.customerService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Customer {
    private String customerName;
    @Id
    private String email;
    private String password;
    private String mobileNo;
//    private List<Address> addressList;
    private Address address;

    public Customer() {
    }

    public Customer(String customerName, String email, String password,
                    String mobileNo,Address address) {

        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.address = address;
//        this.addressList=addressList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Address> getAddressList() {
//        return addressList;
//    }
//
//    public void setAddressList(List<Address> addressList) {
//        this.addressList = addressList;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address=" + address +
                '}';
    }
}
