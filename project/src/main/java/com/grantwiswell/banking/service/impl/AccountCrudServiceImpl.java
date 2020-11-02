package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.AccountCrudDao;
import com.grantwiswell.banking.dao.impl.AccountCrudDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.util.RandomUtil;

public class AccountCrudServiceImpl implements AccountCrudService {

    AccountCrudDao accountCrudDao = new AccountCrudDaoImpl();

    @Override
    public void createNewAccount(int customer_id, double balance, String name) throws BankException {
        if (customer_id > 99 && customer_id < 1000) {
            try {
                accountCrudDao.createNewAccount(customer_id, RandomUtil.generateAccountNumber(), balance, name);
            } catch (BankException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void depositToAccount(double depositAmount, int number) throws BankException {
        if (depositAmount <= 0) throw new BankException("You must deposit a positive amount of money...");
        try {
            accountCrudDao.depositToAccount(depositAmount, number);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdrawalFromAccount(double withdrawalAmount, Account account) throws BankException {
        if (withdrawalAmount <= 0) throw new BankException("You must withdrawal a positive amount of money...");
        if (withdrawalAmount > account.getBalance()) throw new BankException("You cannot withdrawal more money than you have in your account...");
        try {
            accountCrudDao.withdrawalFromAccount(withdrawalAmount, account.getNumber());
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
