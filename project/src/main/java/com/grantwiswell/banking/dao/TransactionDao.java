package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Transaction;

import java.util.List;

public interface TransactionDao {
    public void createTransaction(Transaction transaction) throws BankException;
    public List<Transaction> getTransactions(int account_id) throws BankException;
    public boolean completeTransaction(int transactionId) throws BankException;
}
