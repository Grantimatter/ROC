package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;

import java.util.List;

public interface CustomerSearchDao {
    public Customer getCustomerById(int id) throws BankException;
    public Customer getCustomerByAccount(int accountNumber) throws BankException;
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException;
    public Customer getCustomerByContactNumber(long contactNumber) throws BankException;
    public List<Customer> getAllCustomers() throws BankException;
    public List<Customer> getCustomersByName(String name) throws BankException;
}
