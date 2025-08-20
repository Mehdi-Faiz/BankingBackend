package com.mehdi.BankingBackend.service;

import com.mehdi.BankingBackend.model.Customer;
import com.mehdi.BankingBackend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

}
