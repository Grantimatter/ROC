package com.grantwiswell.banking.dao.queries;

public class CustomerQueries {
    public static final String GET_CUSTOMER_DATA = "SELECT first_name, last_name, id, contact_number, contact_email, status, dob FROM bank.customer";
    public static final String GET_ALL_CUSTOMERS = GET_CUSTOMER_DATA;
    public static final String GET_CUSTOMER_BY_ID = GET_CUSTOMER_DATA + " WHERE id=?;";
    public static final String GET_CUSTOMER_BY_LOGIN = GET_CUSTOMER_DATA + " WHERE contact_email ILIKE ? AND password=?;";
    public static final String GET_CUSTOMERS_BY_FIRST_NAME = GET_CUSTOMER_DATA + " WHERE first_name ILIKE ?;";
    public static final String GET_CUSTOMERS_BY_LAST_NAME = GET_CUSTOMER_DATA + " WHERE last_name ILIKE ?;";
    public static final String GET_CUSTOMER_BY_EMAIL = GET_CUSTOMER_DATA + " WHERE contact_email ILIKE ?;";
    public static final String GET_CUSTOMER_BY_PHONE = GET_CUSTOMER_DATA + " WHERE contact_number ?;";
    public static final String GET_CUSTOMERS_BY_STATUS = GET_CUSTOMER_DATA + " WHERE status ILIKE ?;";
}
