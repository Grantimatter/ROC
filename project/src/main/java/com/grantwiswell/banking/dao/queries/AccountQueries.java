package com.grantwiswell.banking.dao.queries;

public class AccountQueries {
    public static final String GET_ACCOUNT_DATA = "SELECT customer_id, id, balance, name, status FROM bank.account";
    public static final String GET_ACCOUNTS_BY_CUSTOMER_ID = GET_ACCOUNT_DATA + " WHERE customer_id=?;";
    public static final String GET_ACCOUNT_BY_NUMBER = GET_ACCOUNT_DATA + " WHERE id=?;";
    public static final String GET_ACCOUNTS_BY_STATUS = GET_ACCOUNT_DATA + " WHERE status ILIKE ?;";
}
