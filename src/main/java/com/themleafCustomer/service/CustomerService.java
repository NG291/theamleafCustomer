package com.themleafCustomer.service;

import com.themleafCustomer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CustomerService implements ICustomerService{
    private static final Map<Long, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1L, new Customer(1L, "Nguyen", "nguyen@gmail.com", "Nam Dinh"));
        customers.put(2L, new Customer(2L, "Tran", "tran@gmail.com", "Hanoi"));
        customers.put(3L, new Customer(3L, "Le", "le@gmail.com", "Hai Phong"));
        customers.put(4L, new Customer(4L, "Pham", "pham@gmail.com", "Da Nang"));
        customers.put(5L, new Customer(5L, "Hoang", "hoang@gmail.com", "Ho Chi Minh City"));
    }
 @Override
    public List<Customer> findAll() {
       return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
      customers.put(customer.getId(), customer);
    }

    @Override
    public void Update(Long id, Customer customer) {
      customers.put(id, customer);
    }

    @Override
    public void Remove(Long id) {
     customers.remove(id);
    }
}
