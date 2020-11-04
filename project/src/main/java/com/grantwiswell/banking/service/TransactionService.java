package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Transaction;

import java.util.List;

public interface TransactionService {
    public void createTransaction(int account_from, int account_to, double amount) throws BankException;
    public Transaction getNewTransaction(Transaction transaction) throws BankException;
    public Transaction getTransactionById(int id) throws BankException;
    public List<Transaction> getTransactionsByAccountId(int account_id) throws BankException;
    public void completeTransaction(Transaction transaction) throws BankException;
    public String getTransactionStatus(Transaction transaction) throws BankException;
    public void rejectTransaction(Transaction transaction) throws BankException;
}
