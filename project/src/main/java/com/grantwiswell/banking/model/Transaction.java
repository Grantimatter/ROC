package com.grantwiswell.banking.model;

import java.util.Date;

public class Transaction {

    private int id;
    private int account_from;
    private int account_to;
    private double amount;
    private Date date_created;

    private String status;

    public Transaction(int account_from, int account_to, double amount, Date date_created) {
        this.account_from = account_from;
        this.account_to = account_to;
        this.amount = amount;
        this.date_created = date_created;
    }

    public Transaction(int account_from, int account_to, double amount, Date date_created, String status) {
        this(account_from, account_to, amount, date_created);
        this.status = status;
    }

    public Transaction(int id, int account_from, int account_to, double amount, Date date_created, String status) {
        this(account_from, account_to, amount, date_created, status);
        this.id = id;
    }


    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

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
        return "Transaction {" +
                " From : " + account_from +
                ", To : " + account_to +
                ", Amount : " + amount +
                ", status : " + status.toUpperCase() +
                '}';
    }
}
