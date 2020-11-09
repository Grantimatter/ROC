package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;

public interface CustomerCrudDao {
    public boolean createNewCustomer(Customer customer) throws BankException;
    public void updateCustomerStatus(int id, String status) throws BankException;
}
