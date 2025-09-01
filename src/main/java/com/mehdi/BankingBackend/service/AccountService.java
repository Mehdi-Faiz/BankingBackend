package com.mehdi.BankingBackend.service;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.model.Transaction;
import com.mehdi.BankingBackend.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Account getAccount(Long accountId) {
        Account account = this.accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));
        return account;
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
    public List<Transaction> getAccountTransactions(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getTransactions();
    }

    @Transactional
    public Double deposit(Long accountID, Double amount) {
        Account account = this.accountRepository.findById(accountID)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountID));
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        Transaction transaction = new Transaction();

        transaction.setAccount(account);
        transaction.setTypeOfTransaction("DEPOSIT");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        account.getTransactions().add(transaction);

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

        Transaction transaction = new Transaction();

        transaction.setAccount(account);
        transaction.setTypeOfTransaction("WITHDRAW");
        transaction.setAmount(amount * -1);
        transaction.setTimestamp(LocalDateTime.now());
        account.getTransactions().add(transaction);

        account.setBalance(account.getBalance() - amount);
        return account.getBalance();
    }

    @Transactional
    public Double sendMoney(Long senderAccountID, Long receiverAccountID, Double amount) {

        Account senderAccount = this.accountRepository.findById(senderAccountID)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + senderAccountID));

        Account receiverAccount = this.accountRepository.findById(receiverAccountID)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + receiverAccountID));

        if (senderAccount.getBalance() - amount < 0) {
            throw new IllegalArgumentException("Cannot transfer money. No sufficient balance");
        }

        Transaction senderTransaction = new Transaction();
        Transaction receiverTransaction = new Transaction();

        senderTransaction.setAccount(senderAccount);
        senderTransaction.setTypeOfTransaction("Money sent");
        senderTransaction.setAmount(amount * -1);
        senderTransaction.setTimestamp(LocalDateTime.now());
        senderAccount.getTransactions().add(senderTransaction);

        receiverTransaction.setAccount(receiverAccount);
        receiverTransaction.setTypeOfTransaction("Money received");
        receiverTransaction.setAmount(amount);
        receiverTransaction.setTimestamp(LocalDateTime.now());
        senderAccount.getTransactions().add(receiverTransaction);

        senderAccount.setBalance(senderAccount.getBalance() - amount);
        receiverAccount.setBalance(receiverAccount.getBalance() + amount);

        return senderAccount.getBalance();
    }

}
