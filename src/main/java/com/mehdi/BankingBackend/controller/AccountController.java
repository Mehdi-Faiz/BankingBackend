package com.mehdi.BankingBackend.controller;

import com.mehdi.BankingBackend.model.Account;
import com.mehdi.BankingBackend.model.Transaction;
import com.mehdi.BankingBackend.service.AccountService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.coyote.Response;
import org.apache.el.lang.ELArithmetic;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

//Create global error handling system -> Done

//need to add this operations:

//Deposit money -> DONE

//Withdraw money -> Done

//Transfer between accounts -> Done

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

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Map<String, Object>> wihdraw(@PathVariable Long id, @RequestParam Double amount) {
        Double newBalance = accountService.withdraw(id, amount);
        return ResponseEntity.ok(Map.of(
                "message", "Withdraw successful",
                "balance remaining", newBalance
        ));
    }

    @PostMapping("/{sender}/{receiver}/transfer")
    public ResponseEntity<Map<String, Object>> transfer(@PathVariable Long sender, @PathVariable Long receiver, @RequestParam Double amount) {
        Double newBalance = accountService.sendMoney(sender, receiver, amount);
        return ResponseEntity.ok(Map.of(
                "message", "Transfer has been completed successfully",
                "current balance is", newBalance
        ));
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<Transaction>> getTransacions(@PathVariable Long id) {
        Account account = accountService.getAccount(id);
        List<Transaction> transactions = account.getTransactions();
        return ResponseEntity.ok(transactions);
    }
}
