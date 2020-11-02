package com.banking.service.impl;

import com.banking.dao.CustomerCrudDao;
import com.banking.dao.impl.CustomerCrudDaoImpl;
import com.banking.exception.BankException;
import com.banking.service.CustomerCrudService;

public class CustomerCrudServiceImpl implements CustomerCrudService {

    CustomerCrudDao customerCrudDao = new CustomerCrudDaoImpl();

    @Override
    public void createNewCustomer(String contact_email, String password, String name) throws BankException {
        if(!isValidEmail(contact_email)) throw new BankException("Invalid email address! please try again.");
        if(password.length() < 8) throw new BankException("Password must be at least 8 characters! Please try again.");

        try{
            customerCrudDao.createNewCustomer(contact_email, password, name);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isValidEmail(String email){
        // Official RFC5322 standard email syntax used for validation
        return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }
}
