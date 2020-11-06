package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.CustomerSearchDao;
import com.grantwiswell.banking.dao.impl.CustomerSearchDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerSearchService;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class CustomerSearchServiceImpl implements CustomerSearchService {

    private static CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();
    private Logger log = Logger.getLogger(CustomerSearchServiceImpl.class);

    @Override
    public Customer getCustomerById(int id) throws BankException {
        Customer customer = null;
        if(id > 99 && id < 10000){
            try{
                customer = customerSearchDao.getCustomerById(id);
            } catch (BankException e) {
                log.warn(e.getMessage());
            }
        }
        else{
            throw new BankException("Invalid ID! ID must be a 3 digit number");
        }
        return customer;
    }

    @Override
    public Customer getCustomerByAccount(Account account) throws BankException {
        Customer customer = null;
        try{
            customer = customerSearchDao.getCustomerById(account.getCustomer_id());
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
        return customer;
    }

    @Override
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException {
        throw new NotImplementedException();
    }

    @Override
    public Customer getCustomerByContactNumber(long contactNumber) throws BankException {
        throw new NotImplementedException();
    }

    @Override
    public List<Customer> getAllCustomers() throws BankException {
        throw new NotImplementedException();
    }

    @Override
    public List<Customer> getCustomersByName(String name) throws BankException {
        throw new NotImplementedException();
    }

    @Override
    public List<Customer> getCustomersByStatus(String status) throws BankException {
        if(!(status.equalsIgnoreCase("ACCEPTED") || status.equalsIgnoreCase("PENDING") || status.equalsIgnoreCase("REJECTED"))){ throw new BankException(status + " is not a recognized status! Please try again..."); }
        List<Customer> customerList = new ArrayList<>();
        try{
            customerList = customerSearchDao.getCustomersByStatus(status);
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
        return customerList;
    }
}
