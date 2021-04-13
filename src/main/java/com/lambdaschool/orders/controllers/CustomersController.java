package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Tells the Java Spring that his is a rest controller
@RequestMapping("/customers") //Entry point for people to access Customer Data
public class CustomersController
{
    //This will process customer data
    @Autowired
    private CustomerService customerService;


    //Returns a list of all the customers
    //http://localhost:2019/customers/orders

    @GetMapping(value = "/orders",
    produces = {"application/json"})
    public ResponseEntity<?> ListAllCustomers()
    {
        List<Customer> myCustomers = customerService.findAllCustomers();
        return new ResponseEntity<>(myCustomers,
                    HttpStatus.OK);
    }

    //Return a single Customer based off an id number
    //http://localhost:2019/customers/customer/5

    @GetMapping(value = "/customer/{custid}",
        produces = {"application/json"})
    public ResponseEntity<?> getCustomerById(
            @PathVariable
                long custid)
    {
        Customer c = customerService.findCustomerById(custid);
        return  new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/sun
    @GetMapping(value = "namelike/{custname}",
        produces = {"application/json"})
    public ResponseEntity<?> findCustomerByName(
            @PathVariable //is something that will change in the mapping!
                String custname)
    {
        List<Customer> myCustomerList = customerService.findByCustomerName(custname);
        return new ResponseEntity<>(myCustomerList, HttpStatus.OK);
    }



}
