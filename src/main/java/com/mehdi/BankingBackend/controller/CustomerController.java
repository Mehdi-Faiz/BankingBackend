package com.mehdi.BankingBackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehdi.BankingBackend.dto.AccountDTO;
import com.mehdi.BankingBackend.dto.CustomerCreateDTO;
import com.mehdi.BankingBackend.dto.CustomerDTO;
import com.mehdi.BankingBackend.model.Customer;
import com.mehdi.BankingBackend.repository.CustomerRepository;
import com.mehdi.BankingBackend.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerCreateDTO customerCreateDTO) {

        Customer customer = new Customer();

        customer.setEmail(customerCreateDTO.getEmail());
        customer.setPassword(customerCreateDTO.getPassword());

        Customer savedCustomer = customerService.createCustomer(customer);

        return toCustomerDTO(savedCustomer);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        //returns customer dto instead of full customer entity
        return customerService.getAllCustomers().stream().map(this::toCustomerDTO).toList();
    }

    private CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setEmail(customer.getEmail());

        // map accounts
        List<AccountDTO> accountDTOs = customer.getAccounts().stream().map(account -> {
            AccountDTO accDto = new AccountDTO();
//            accDto.setId(account.getId());
            accDto.setAccountNumber(account.getAccountNumber());
            accDto.setBalance(account.getBalance());
            return accDto;
        }).toList();

        dto.setAccounts(accountDTOs);
        return dto;
    }
}
