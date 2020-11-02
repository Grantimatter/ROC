package com.grantwiswell.banking.dao.queries;

public class AccountCrud {
    public static final String CREATE_NEW_ACCOUNT = "INSERT INTO bank.account (customer_id, number, balance, name) VALUES (?,?,?,?)";
    public static final String DEPOSIT_TO_ACCOUNT = "UPDATE bank.account SET balance=balance+? WHERE number=?";
    public static final String WITHDRAWAL_FROM_ACCOUNT = "UPDATE bank.account SET balance=balance-? WHERE number=?";
}
