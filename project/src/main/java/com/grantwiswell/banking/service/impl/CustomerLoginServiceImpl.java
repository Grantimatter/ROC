package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.CustomerLoginDao;
import com.grantwiswell.banking.dao.impl.CustomerLoginDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService {

    private CustomerLoginDao customerLoginDao = new CustomerLoginDaoImpl();

    @Override
    public Customer getCustomerFromLogin(String contactEmail, String password) throws BankException {
        Customer customer = null;
        if(password != null && password.length() > 7){
            customer = customerLoginDao.getCustomerFromLogin(contactEmail, password);
        } else{
            throw new BankException("Password must be at least 8 characters... Try again");
        }
        return customer;
    }
}
