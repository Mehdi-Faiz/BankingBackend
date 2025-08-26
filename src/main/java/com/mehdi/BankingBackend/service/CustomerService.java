package com.mehdi.BankingBackend.service;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.model.Customer;
import com.mehdi.BankingBackend.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {

        //opens and assign an account to the new customer
        Account account = new Account();
        account.setAccountNumber("ACC-" + System.currentTimeMillis());
        account.setBalance(600.0);

        //syncs the account and customer in the 2 classes
        account.setCustomer(customer);
        customer.getAccounts().add(account);


        return this.customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

}
