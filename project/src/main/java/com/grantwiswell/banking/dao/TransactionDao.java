package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Transaction;

import java.util.List;

public interface TransactionDao {
    public int createTransaction(Transaction transaction) throws BankException;
    public Transaction getTransactionById(int id) throws BankException;
    public List<Transaction> getTransactions(int account_id) throws BankException;
    public Transaction getNewTransaction(Transaction transaction) throws BankException;
    public int completeTransaction(Transaction transaction) throws BankException;
    public String getTransactionStatus(Transaction transaction) throws BankException;
    public int rejectTransaction(Transaction transaction) throws BankException;
    public List<Transaction> getAllTransactions() throws BankException;
}
