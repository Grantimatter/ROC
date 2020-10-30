package com.banking.service.impl;

import com.banking.dao.CustomerLoginDao;
import com.banking.dao.impl.CustomerLoginDaoImpl;
import com.banking.exception.BankException;
import com.banking.model.Customer;
import com.banking.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService {

    private CustomerLoginDao customerLoginDao = new CustomerLoginDaoImpl();

    @Override
    public Customer validateLogin(String contactEmail, String password) throws BankException {
        Customer customer = null;
        if(password.length() > 7){
            customer = customerLoginDao.validateLogin(contactEmail, password);
        } else{
            throw new BankException("Password must be at least 8 characters... Try again");
        }
        return customer;
    }
}
