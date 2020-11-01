package com.banking.service.impl;

import com.banking.dao.CustomerCrudDao;
import com.banking.dao.impl.CustomerCrudDaoImpl;
import com.banking.exception.BankException;
import com.banking.service.CustomerCrudService;

public class CustomerCrudServiceImpl implements CustomerCrudService {

    CustomerCrudDao customerCrudDao = new CustomerCrudDaoImpl();

    @Override
    public void createNewCustomer(String name, String contact_email, String password) throws BankException {
        if(!isValidEmail(contact_email)) throw new BankException("Invalid email address! please try again.");
        if(password.length() < 8) throw new BankException("Password must be at least 8 characters! Please try again.");

        //TODO CUSTOMER CRUD DAO
    }

    private boolean isValidEmail(String email){
        return email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,63}$");
    }
}
