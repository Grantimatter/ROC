package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;

import java.util.List;

// Only employees should be able to search for customer accounts
public interface CustomerSearchService {
    public Customer getCustomerById(int id) throws BankException;
    public Customer getCustomerByAccount(Account account) throws BankException;
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException;
    public List<Customer> getAllCustomers() throws BankException;
    public List<Customer> getCustomersByFirstName(String name) throws BankException;
    public List<Customer> getCustomersByLastName(String name) throws BankException;
    public List<Customer> getCustomersByStatus(String status) throws BankException;
}
