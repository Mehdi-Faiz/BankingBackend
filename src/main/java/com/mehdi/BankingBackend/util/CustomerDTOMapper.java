package com.mehdi.BankingBackend.util;

import com.mehdi.BankingBackend.dto.AccountDTO;
import com.mehdi.BankingBackend.dto.CustomerDTO;
import com.mehdi.BankingBackend.model.Customer;

import java.util.List;

public class CustomerDTOMapper {

    public static CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setEmail(customer.getEmail());

        // map accounts
        List<AccountDTO> accountDTOs = customer.getAccounts().stream().map(account -> {
            AccountDTO accDto = new AccountDTO();
            accDto.setId(account.getId());
            accDto.setAccountNumber(account.getAccountNumber());
            accDto.setBalance(account.getBalance());
            return accDto;
        }).toList();

        dto.setAccounts(accountDTOs);
        return dto;
    }
}
