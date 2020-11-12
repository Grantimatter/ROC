package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerSearchDao;
import com.grantwiswell.banking.dao.queries.CustomerQueries;
import com.grantwiswell.banking.dao.util.DaoCustomerUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.impl.util.QueryUtil;
import com.grantwiswell.banking.util.FormatStrings;
import org.apache.log4j.Logger;

import java.util.List;

public class CustomerSearchDaoImpl implements CustomerSearchDao {

    Logger log = Logger.getLogger(CustomerSearchDaoImpl.class);

    @Override
    public Customer getCustomerById(int id) throws BankException {
        Customer customer = DaoCustomerUtil.getNextCustomerFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMER_BY_ID, id));
        if(customer == null) throw new BankException("No customer found with ID \""+id+"\"");
        return customer;
    }

    @Override
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException {
        Customer customer = DaoCustomerUtil.getNextCustomerFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMER_BY_EMAIL, contactEmail));
        if(customer == null) throw new BankException("No customer found with email \""+contactEmail+"\"");
        return customer;
    }

    @Override
    public Customer getCustomerByContactNumber(long contactNumber) throws BankException {
        Customer customer = DaoCustomerUtil.getNextCustomerFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMER_BY_PHONE, contactNumber));
        if(customer == null) throw new BankException("No customer found with phone number \""+ FormatStrings.formatPhoneNumber(contactNumber) +"\"");
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws BankException {
        List<Customer> customerList = DaoCustomerUtil.getCustomersFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_ALL_CUSTOMERS));
        if(customerList == null || customerList.size() == 0) throw new BankException("There are no customers in the database");
        return customerList;
    }

    @Override
    public List<Customer> getCustomersByFirstName(String first_name) throws BankException {
        List<Customer> customerList = DaoCustomerUtil.getCustomersFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMERS_BY_FIRST_NAME, first_name));
        if(customerList == null || customerList.size() == 0) throw new BankException("There are no customers with the first name \""+first_name+"\"");
        return customerList;
    }

    @Override
    public List<Customer> getCustomersByLastName(String last_name) throws BankException {
        List<Customer> customerList = DaoCustomerUtil.getCustomersFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMERS_BY_LAST_NAME, last_name));
        if(customerList == null || customerList.size() == 0) throw new BankException("There are no customers with the last name \""+last_name+"\"");
        return customerList;
    }

    @Override
    public List<Customer> getCustomersByStatus(String status) throws BankException {
        List<Customer> customerList = DaoCustomerUtil.getCustomersFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMERS_BY_STATUS, status));
        if(customerList == null || customerList.size() == 0) throw new BankException("There are no customers of status \""+status+"\"");
        return customerList;
    }
}
