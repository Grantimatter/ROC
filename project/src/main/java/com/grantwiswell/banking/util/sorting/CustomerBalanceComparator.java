package com.grantwiswell.banking.util.sorting;

import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;

import java.util.Comparator;

public class CustomerBalanceComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        double c1Balance = 0;
        for(Account acc:c1.getAccounts()){
            c1Balance += acc.getBalance();
        }
        double c2Balance = 0;
        for(Account acc:c2.getAccounts()){
            c2Balance += acc.getBalance();
        }

        return (int)(c1Balance - c2Balance);
    }
}
