package com.banking.dao.queries;

public class CustomerQueries {
    public static final String GET_CUSTOMER_DATA = "SELECT name, id, contact_number, contact_email, account_numbers FROM bank.customer";
    public static final String GET_ALL_CUSTOMERS = GET_CUSTOMER_DATA;
    public static final String GET_CUSTOMER_BY_ID = GET_CUSTOMER_DATA + " WHERE id=?";
    public static final String GET_CUSTOMER_BY_LOGIN = GET_CUSTOMER_DATA + " WHERE contact_email=? AND password=?";
    public static final String GET_CUSTOMER_BY_EMAIL = GET_CUSTOMER_DATA + " WHERE contact_email=?";
    public static final String GET_CUSTOMER_BY_PHONE = GET_CUSTOMER_DATA + " WHERE contact_number=?";
    public static final String GET_CUSTOMER_BY_ACCOUNT_NUMBER = GET_CUSTOMER_DATA + " WHERE '?'=ANY(account_numbers)";
    public static final String GET_CUSTOMERS_BY_NAME = GET_CUSTOMER_DATA + " WHERE name=?";
}
