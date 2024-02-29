package com.cg.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Account;
import com.cg.entity.Transaction;
import com.cg.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionService transactionService;

    public double getAccountBalance(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("From Account not found"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("To Account not found"));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance in the from account");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Record transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setFromAccountId(fromAccountId);
        transaction.setToAccountId(toAccountId);
        transaction.setTimestamp(LocalDateTime.now());
        transactionService.saveTransaction(transaction);
    }
}