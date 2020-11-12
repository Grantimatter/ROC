package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.AccountSearchDao;
import com.grantwiswell.banking.dao.impl.AccountSearchDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.impl.util.ValidationUtil;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class AccountSearchServiceImpl implements AccountSearchService {

    AccountSearchDao accountSearchDao = new AccountSearchDaoImpl();

    private Logger log = Logger.getLogger(AccountSearchServiceImpl.class);

    @Override
    public Account getAccountById(int number) throws BankException {
        if (!ValidationUtil.isValidAccountId(number))
            throw new BankException("Invalid Account Number. Account number must be a 6 digits");
        try {
            return accountSearchDao.getAccountByNumber(number);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerId) throws BankException {
        if (!ValidationUtil.isValidCustomerId(customerId))
            throw new BankException("Invalid ID... Customer ID must be a 3-digit whole number");
        try {
            return accountSearchDao.getAccountsByCustomerId(customerId);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Account> getAccountsByStatus(String status) throws BankException {
        if (!(status.equalsIgnoreCase("ACCEPTED") || status.equalsIgnoreCase("PENDING") || status.equalsIgnoreCase("REJECTED")))
            throw new BankException(status + " is not a valid status...");
        try {
            return accountSearchDao.getAccountsByStatus(status);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }
}
