package com.mehdi.BankingBackend.controller;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.service.AccountService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//need to add this operations:
//Deposit money
//Withdraw money
//Transfer between accounts
//Check balance

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
}
