package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.AccountSearchDao;
import com.grantwiswell.banking.dao.impl.AccountSearchDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.AccountSearchService;

import java.util.ArrayList;
import java.util.List;

public class AccountSearchServiceImpl implements AccountSearchService {

    AccountSearchDao accountSearchDao = new AccountSearchDaoImpl();

    @Override
    public Account getAccountByNumber(int number) throws BankException {
        return null;
    }

    @Override
    public List<Account> getAccountInBalanceRange(double minBalance, double maxBalance) throws BankException {
        List<Account> accounts = new ArrayList();

        return accounts;
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerId) throws BankException {
        List<Account> accounts = new ArrayList();
        if(customerId > 99 && customerId < 1000){
            try {
                accounts = accountSearchDao.getAccountsByCustomerId(customerId);
            } catch(BankException e){
                System.out.println(e.getMessage());
            }
        }else{
            throw new BankException("Invalid ID... Customer ID must be a 3-digit whole number");
        }
        return accounts;
    }
}
