package com.grantwiswell.banking.dao.queries;

public class CustomerCrud {
    public static final String CREATE_CUSTOMER = "INSERT INTO bank.customer (first_name, last_name, contact_email, password) VALUES (?,?,?,?)";
}
