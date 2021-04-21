package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    List<Customer> findByCustomerName(String custname);
    Customer findCustomersById(Long id);

    Customer findCustomerById(long custid);
}
