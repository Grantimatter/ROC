package com.grantwiswell.banking.util.sorting;

import com.grantwiswell.banking.model.Customer;

import java.util.Comparator;

public class CustomerAccountComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return c1.getAccounts().size() - c2.getAccounts().size();
    }
}
