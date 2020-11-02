package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.AccountCrudDao;
import com.grantwiswell.banking.dao.impl.AccountCrudDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.util.RandomUtil;

public class AccountCrudServiceImpl implements AccountCrudService {

    AccountCrudDao accountCrudDao = new AccountCrudDaoImpl();

    @Override
    public void createNewAccount(int customer_id, double balance, String name) throws BankException {
        if(customer_id > 99 && customer_id < 1000){
            try {
                accountCrudDao.createNewAccount(customer_id, RandomUtil.generateAccountNumber(), balance, name);
            } catch (BankException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
