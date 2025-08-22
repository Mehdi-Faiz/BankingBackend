package com.mehdi.BankingBackend.service;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return this.accountRepository.save(account);
    }

//    public List<Account> getAllAccounts() {
//        return this.accountRepository.findAll();
//    }
}
