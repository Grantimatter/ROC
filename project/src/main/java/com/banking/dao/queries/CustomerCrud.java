package com.banking.dao.queries;

public class CustomerCrud {
    public static final String CREATE_ACCOUNT = "UPDATE bank.customer SET account_numbers = array_append(account_numbers, ?) WHERE name=?";
    public static final String CREATE_CUSTOMER = "INSERT INTO bank.customer ()";
}
