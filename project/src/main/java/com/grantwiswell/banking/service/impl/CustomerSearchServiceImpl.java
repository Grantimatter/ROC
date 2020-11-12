package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.CustomerSearchDao;
import com.grantwiswell.banking.dao.impl.CustomerSearchDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.impl.util.ValidationUtil;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class CustomerSearchServiceImpl implements CustomerSearchService {

    private static CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();
    private Logger log = Logger.getLogger(CustomerSearchServiceImpl.class);

    @Override
    public Customer getCustomerById(int id) throws BankException {
        if(!ValidationUtil.isValidCustomerId(id)) throw new BankException("This is an invalid ID");
            try{
                return customerSearchDao.getCustomerById(id);
            } catch (BankException e) {
                InputUtil.setMessagePrompt(e.getMessage());
            }
        return null;
    }

    @Override
    public Customer getCustomerByAccount(Account account) throws BankException {
        try{
            return customerSearchDao.getCustomerById(account.getCustomer_id());
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }

    @Override
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException {
        try{
            if(ValidationUtil.isValidEmail(contactEmail)){
                return customerSearchDao.getCustomerByContactEmail(contactEmail);
            }
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() throws BankException {
        try{
            return customerSearchDao.getAllCustomers();
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersByFirstName(String name) throws BankException {
        if(name == null || name.length() ==0) throw new BankException("An invalid first name has been entered");
        try {
            return customerSearchDao.getCustomersByFirstName(name);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersByLastName(String name) throws BankException {
        if(name == null || name.length() ==0) throw new BankException("An invalid last name has been entered");
        try {
            return customerSearchDao.getCustomersByLastName(name);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersByStatus(String status) throws BankException {
        if(!(status.equalsIgnoreCase("ACCEPTED") || status.equalsIgnoreCase("PENDING") || status.equalsIgnoreCase("REJECTED"))){ throw new BankException(status + " is not a recognized status! Please try again..."); }
        try{
            return customerSearchDao.getCustomersByStatus(status);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }
}
