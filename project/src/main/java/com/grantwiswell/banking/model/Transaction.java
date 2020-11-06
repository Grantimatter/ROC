package com.grantwiswell.banking.model;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.Locale;

public class Transaction {

    private int id;
    private int account_from;
    private int account_to;
    private double amount;
    private Timestamp timestamp;
    private String status;

    public Transaction(int account_from, int account_to, double amount, Timestamp timestamp) {
        this.account_from = account_from;
        this.account_to = account_to;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(int account_from, int account_to, double amount, Timestamp timestamp, String status) {
        this(account_from, account_to, amount, timestamp);
        this.status = status;
    }

    public Transaction(int id, int account_from, int account_to, double amount, Timestamp timestamp, String status) {
        this(account_from, account_to, amount, timestamp, status);
        this.id = id;
    }

    public Timestamp getTimestamp() { return timestamp; }

    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_from() {
        return account_from;
    }

    public void setAccount_from(int account_from) {
        this.account_from = account_from;
    }

    public int getAccount_to() {
        return account_to;
    }

    public void setAccount_to(int account_to) {
        this.account_to = account_to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "| From: #" + account_from +
                " | To: #" + account_to +
                " | Amount: " + NumberFormat.getCurrencyInstance(Locale.US).format(amount) +
                (status != null ? " | Status: " + status.toUpperCase(): "") + " |";
    }
}
