package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.AccountCrudDao;
import com.grantwiswell.banking.dao.impl.AccountCrudDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.util.RandomUtil;
import org.apache.log4j.Logger;

public class AccountCrudServiceImpl implements AccountCrudService {

    AccountCrudDao accountCrudDao = new AccountCrudDaoImpl();
    AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private Logger log = Logger.getLogger(AccountCrudServiceImpl.class);

    @Override
    public void createNewAccount(int customer_id, double balance, String name) throws BankException {
        if (customer_id < 100 || customer_id > 999) throw new BankException("Customer ID is invalid");
        if (balance <= 0) throw new BankException ("You cannot start an account with a negative balance...");
        try {
            accountCrudDao.createNewAccount(customer_id, RandomUtil.generateAccountNumber(), balance, name);
        } catch (BankException e) {
            log.info(e.getMessage());
        }

    }

    @Override
    public void depositToAccount(double depositAmount, int number) throws BankException {
        if (depositAmount <= 0) throw new BankException("You must deposit a positive amount of money...");
        try {
            accountCrudDao.depositToAccount(depositAmount, number);
        } catch (BankException e) {
            log.info(e.getMessage());
        }
    }

    @Override
    public void withdrawalFromAccount(double withdrawalAmount, Account account) throws BankException {
        if (withdrawalAmount <= 0) throw new BankException("You must withdrawal a positive amount of money...");
        if (withdrawalAmount > account.getBalance())
            throw new BankException("You cannot withdrawal more money than you have in your account...");
        try {
            accountCrudDao.withdrawalFromAccount(withdrawalAmount, account.getId());
        } catch (BankException e) {
            log.info(e.getMessage());
        }
    }

    public void withdrawalFromAccount(double withdrawalAmount, int id) throws BankException {
        Account account = accountSearchService.getAccountById(id);
        if (withdrawalAmount <= 0) throw new BankException("You must withdrawal a positive amount of money...");
        if (withdrawalAmount > account.getBalance())
            throw new BankException("You cannot withdrawal more money than you have in your account...");
        try {
            accountCrudDao.withdrawalFromAccount(withdrawalAmount, id);
        } catch (BankException e) {
            log.info(e.getMessage());
        }
    }
}
