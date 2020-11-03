package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.CustomerSearchDao;
import com.grantwiswell.banking.dao.impl.CustomerSearchDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerSearchService;
import org.apache.log4j.Logger;

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
                log.info(e);
            }
        }
        else{
            throw new BankException("Invalid ID! ID must be a 3 digit number");
        }
        return customer;
    }

    @Override
    public Customer getCustomerByAccount(int accountNumber) throws BankException {
        return null;
    }

    @Override
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException {
        return null;
    }

    @Override
    public Customer getCustomerByContactNumber(long contactNumber) throws BankException {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() throws BankException {
        return null;
    }

    @Override
    public List<Customer> getCustomersByName(String name) throws BankException {
        return null;
    }
}
