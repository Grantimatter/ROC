package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Transaction;

import java.util.List;

public interface TransactionService {
    public void createTransaction(int account_from, int account_to, double amount) throws BankException;
    public List<Transaction> getTransactions(int account_id) throws BankException;
    public boolean completeTransaction(int transactionId) throws BankException;
}
