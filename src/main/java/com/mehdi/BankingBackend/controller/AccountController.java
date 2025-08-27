package com.mehdi.BankingBackend.controller;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.service.AccountService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;


//need to add this operations:
//Deposit money
//Withdraw money
//Transfer between accounts

//Check balance -> DONE

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}/balance")
    public Double getBalance(@PathVariable Long id) {
        return accountService.getBalance(id);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Map<String, Object>> deposit(@PathVariable Long id, @RequestParam Double amount) {

        Double newBalance = accountService.deposit(id, amount);
        return ResponseEntity.ok(Map.of(
                "message", "Deposit successful",
                "balance", newBalance
        ));
    }
}
