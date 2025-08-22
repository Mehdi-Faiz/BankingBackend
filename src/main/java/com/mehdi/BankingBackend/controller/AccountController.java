package com.mehdi.BankingBackend.controller;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.service.AccountService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @PostMapping
//    public Account createAccount(@RequestBody Account account) {
//        return this.accountService.createAccount(account);
//    }
//
//    @GetMapping
//    public List<Account> getAccounts() {
//        return this.accountService.getAllAccounts();
//    }
}
