package com.grantwiswell.banking.util.sorting;

import com.grantwiswell.banking.model.Customer;

import java.time.Period;
import java.util.Comparator;
import java.util.Date;

public class AgeComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c1, Customer c2) {
        return c1.getDob().before(c2.getDob()) ? 1 : 0;
    }
}
