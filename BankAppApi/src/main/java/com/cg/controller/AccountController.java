package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Account;
import com.cg.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created successfully");
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getAccountBalance(@PathVariable("id") Long accountId) {
        double balance = accountService.getAccountBalance(accountId);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount) {
        accountService.transferMoney(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("Money transferred successfully");
    }
}
