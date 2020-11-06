package com.grantwiswell.banking.functional;

import com.grantwiswell.banking.model.Customer;

@FunctionalInterface
public interface UpdateCustomer {
    public Customer updateCustomer(Customer customer);
}
