package com.mehdi.BankingBackend.repository;

import com.mehdi.BankingBackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
