package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Transaction;
import com.cg.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
   

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByFromAccountIdOrToAccountIdOrderByTimestampDesc(accountId, accountId);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
