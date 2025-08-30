package com.mehdi.BankingBackend.service;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.repository.AccountRepository;
import jakarta.transaction.Transactional;
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

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    public Double getBalance(Long accountId) {
        Account account = this.accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));
        return account.getBalance();
    }

    @Transactional
    public Double deposit(Long accountID, Double amount) {
        Account account = this.accountRepository.findById(accountID)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountID));
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        account.setBalance(amount + account.getBalance());
        return account.getBalance();
    }

    @Transactional
    public Double withdraw(Long accountID, Double amount) {
        Account account = this.accountRepository.findById(accountID)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountID));
        if (account.getBalance() - amount < 0) {
            throw new IllegalArgumentException("Withdraw amount more then current balance");
        }
        account.setBalance(account.getBalance() - amount);
        return account.getBalance();
    }

}
