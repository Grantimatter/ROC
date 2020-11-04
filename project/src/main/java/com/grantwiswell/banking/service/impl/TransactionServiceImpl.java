package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.TransactionDao;
import com.grantwiswell.banking.dao.impl.TransactionDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.TransactionService;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao = new TransactionDaoImpl();
    private AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private Logger log = Logger.getLogger(TransactionServiceImpl.class);

    @Override
    public void createTransaction(int account_from_id, int account_to_id, double amount) throws BankException {
        Account account_from = accountSearchService.getAccountById(account_from_id);
        if(account_from_id == account_to_id) throw new BankException("You cannot start a transfer into the same account");
        if(account_from_id < 100000 || account_from_id > 999999 || account_to_id < 100000 || account_to_id > 999999) throw new BankException("One of the accounts entered is an invalid number. Account numbers must be 6 digits");
        if(account_from.getBalance() < amount) throw new BankException("You cannot transfer more money than what is in your account.");
        try{
            Date date = new Date();
            log.info(date);
            Transaction transaction = new Transaction(account_from_id, account_to_id, amount, new Date());
            transactionDao.createTransaction(transaction);
            accountCrudService.withdrawalFromAccount(amount, account_from);
        } catch (BankException e) {
            log.info(e);
        }
    }

    @Override
    public List<Transaction> getTransactions(int account_id) throws BankException {
        List<Transaction> transactions = new ArrayList<>();
        if(account_id > 999999 || account_id < 100000) throw new BankException("Invalid account number. Account number must be 6 digits");
        try{
            transactions = transactionDao.getTransactions(account_id);
        } catch (BankException e) {
            log.warn(e);
        }
        return transactions;
    }

    @Override
    public boolean completeTransaction(int transactionId) throws BankException {
        throw new NotImplementedException();
    }
}
