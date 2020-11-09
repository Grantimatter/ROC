package com.grantwiswell.banking.dao.queries;

public class CustomerCrud {
    public static final String CREATE_CUSTOMER = "INSERT INTO bank.customer (first_name, last_name, contact_email, password, dob, status) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_CUSTOMER_STATUS = "UPDATE bank.customer SET status=? WHERE id=?";
}
