package com.themleafCustomer.service;

import com.themleafCustomer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void Update(Long id, Customer customer);

    void Remove(Long id);
}
