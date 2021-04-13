package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomersRepository custrepos;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();

        custrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Customer> findByCustomerName(String custname) {
        return custrepos.findByCustnameContainingIngnoringCase(custname);
    }

    @Override
    public Customer findCustomersById(Long id) {
        return null;
    }
}
