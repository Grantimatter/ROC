package com.banking.dao.queries;

public class AccountQueries {
    public static final String GET_ACCOUNTS_BY_CUSTOMER_ID = "SELECT customer_id, number, balance, name FROM bank.account WHERE customer_id=?";
}
