package com.grantwiswell.banking.dao.queries;

public class CustomerQueries {
    public static final String GET_CUSTOMER_DATA = "SELECT first_name, last_name, id, contact_number, contact_email, status FROM bank.customer";
    public static final String GET_ALL_CUSTOMERS = GET_CUSTOMER_DATA;
    public static final String GET_CUSTOMER_BY_ID = GET_CUSTOMER_DATA + " WHERE id=?";
    public static final String GET_CUSTOMER_BY_LOGIN = GET_CUSTOMER_DATA + " WHERE UPPER(contact_email)=? AND password=?";
    public static final String GET_CUSTOMERS_BY_FIRST_NAME = GET_CUSTOMER_DATA + " WHERE UPPER(first_name)=?";
    public static final String GET_CUSTOMERS_BY_LAST_NAME = GET_CUSTOMER_DATA + " WHERE UPPER(last_name)=?";
    public static final String GET_CUSTOMER_BY_EMAIL = GET_CUSTOMER_DATA + " WHERE UPPER(contact_email)=?";
    public static final String GET_CUSTOMER_BY_PHONE = GET_CUSTOMER_DATA + " WHERE contact_number=?";
}
