package com.grantwiswell.banking.dao.queries;

public class TransactionQueries {
    public static final String CREATE_NEW_TRANSACTION = "INSERT INTO bank.transaction (account_from, account_to, amount, date_created, status) VALUES (?,?,?,?,'PENDING');";
    public static final String GET_TRANSACTION_DATA = "SELECT id, account_from, account_to, amount, date_created, status FROM bank.transaction";
    public static final String GET_TRANSACTIONS_INVOLVING_ACCOUNT = GET_TRANSACTION_DATA + " WHERE account_from=? OR account_to=? ORDER BY status DESC, date_created ASC;";
    public static final String GET_NEW_TRANSACTION = GET_TRANSACTION_DATA + " WHERE account_from=? AND account_to=? AND amount=? AND date_created=? AND status='PENDING';";
    public static final String GET_TRANSACTION_BY_ID = GET_TRANSACTION_DATA + " WHERE id=?;";
    public static final String GET_TRANSACTION_STATUS = "SELECT status FROM bank.transaction WHERE id=?;";
    public static final String UPDATE_TRANSACTION_STATUS = "UPDATE bank.transaction SET status=? WHERE id=?;";
}
