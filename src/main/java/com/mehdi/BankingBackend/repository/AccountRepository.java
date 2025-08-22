package com.mehdi.BankingBackend.repository;

import com.mehdi.BankingBackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}