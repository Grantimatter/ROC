package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;

public interface CustomerCrudDao {
    public int createNewCustomer(Customer customer) throws BankException;
    public int updateCustomerStatus(int id, String status) throws BankException;
}
