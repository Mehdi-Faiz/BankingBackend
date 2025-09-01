package com.mehdi.BankingBackend.repository;

import com.mehdi.BankingBackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}