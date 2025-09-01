package com.mehdi.BankingBackend.service;

import com.mehdi.BankingBackend.model.Transaction;
import com.mehdi.BankingBackend.repository.TransactionRepository;

public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }
}
