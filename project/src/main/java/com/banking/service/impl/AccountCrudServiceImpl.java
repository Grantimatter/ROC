package com.banking.service.impl;

import com.banking.dao.AccountCrudDao;
import com.banking.dao.impl.AccountCrudDaoImpl;
import com.banking.exception.BankException;
import com.banking.service.AccountCrudService;
import com.banking.util.RandomGenerator;

public class AccountCrudServiceImpl implements AccountCrudService {

    AccountCrudDao accountCrudDao = new AccountCrudDaoImpl();

    @Override
    public void createNewAccount(int customer_id, double balance, String name) throws BankException {
        if(customer_id > 99 && customer_id < 1000){
            try {
                accountCrudDao.createNewAccount(customer_id, RandomGenerator.generateAccountNumber(), balance, name);
            } catch (BankException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
