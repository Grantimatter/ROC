package com.grantwiswell.banking.dao.queries;

public class AccountCrud {
    public static final String CREATE_NEW_ACCOUNT = "INSERT INTO bank.account (customer_id, number, balance, name) VALUES (?,?,?,?)";
}
