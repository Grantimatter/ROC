package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.TransactionDao;
import com.grantwiswell.banking.dao.impl.TransactionDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.TransactionService;
import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao = new TransactionDaoImpl();
    private AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
    private Logger log = Logger.getLogger(TransactionServiceImpl.class);

    @Override
    public void createTransaction(int account_from_id, int account_to_id, double amount) throws BankException {
        if (account_from_id == account_to_id)
            throw new BankException("You cannot start a transfer into the same account");
        if (account_from_id < 100000 || account_from_id > 999999 || account_to_id < 100000 || account_to_id > 999999)
            throw new BankException("One of the accounts entered is an invalid number. Account numbers must be 6 digits");
        try {
            Account account_from = accountSearchService.getAccountById(account_from_id);
            Account account_to = accountSearchService.getAccountById(account_to_id);
            if (account_to == null || account_from == null)
                throw new BankException("At least one of the accounts in this transaction do not exist...");
            if (account_from.getBalance() < amount)
                throw new BankException("You cannot transfer more money than what is in your account.");

            Transaction transaction = new Transaction(account_from_id, account_to_id, amount, new java.sql.Timestamp(Instant.now().getEpochSecond() * 1000L));
            transactionDao.createTransaction(transaction);
            accountCrudService.withdrawalFromAccount(amount, account_from);

            Customer customer_from = null;
            Customer customer_to = null;
            try {
                customer_from = customerSearchService.getCustomerByAccount(account_from);
                customer_to = customerSearchService.getCustomerByAccount(account_to);
            } catch (BankException e) {
                log.warn(e.getMessage());
            }

            if (customer_from != null && customer_to != null && customer_from.getId() == customer_to.getId()) {

                completeTransaction(transactionDao.getNewTransaction(transaction));
            }
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }

    @Override
    public Transaction getNewTransaction(Transaction transaction) throws BankException {
        try {
            transaction = transactionDao.getNewTransaction(transaction);
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
        return transaction;
    }

    @Override
    public Transaction getTransactionById(int id) throws BankException {
        Transaction transaction = null;
        try {
            transaction = transactionDao.getTransactionById(id);
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
        return transaction;
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int account_id) throws BankException {
        List<Transaction> transactions = new ArrayList<>();
        if (account_id > 999999 || account_id < 100000) throw new BankException("Invalid account number. Account number must be 6 digits");
        try {
            transactions = transactionDao.getTransactions(account_id);
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
        return transactions;
    }

    @Override
    public String getTransactionStatus(Transaction transaction) throws BankException {
        try {
            return transactionDao.getTransactionStatus(transaction);
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
        throw new BankException("Unable to determine transaction status");
    }

    @Override
    public void completeTransaction(Transaction transaction) throws BankException {
        if (getTransactionStatus(transaction).equalsIgnoreCase("COMPLETED")) throw new BankException("Transaction has already been completed, you may not complete it again...");
        if(getTransactionStatus(transaction).equalsIgnoreCase("REJECTED")) throw new BankException("Transaction has been rejected, nothing further can be done");

        try {
            accountCrudService.depositToAccount(transaction.getAmount(), accountSearchService.getAccountById(transaction.getAccount_to()));
            transactionDao.completeTransaction(transaction);
            log.info("Transaction has been completed");
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }

    @Override
    public void rejectTransaction(Transaction transaction) throws BankException {
        try{
            if(transaction.getStatus().equalsIgnoreCase("REJECTED") || transaction.getStatus().equalsIgnoreCase("COMPLETED")) throw new BankException("This transaction is already finalized. You may not perform any operations on it");
            transactionDao.rejectTransaction(transaction);
            Account account_from = accountSearchService.getAccountById(transaction.getAccount_from());
            accountCrudService.depositToAccount(transaction.getAmount(), account_from);
            log.info("Transaction rejected and " + NumberFormat.getCurrencyInstance(Locale.US).format(transaction.getAmount()) + " has been deposited back into account #"+transaction.getAccount_from());
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }
}
