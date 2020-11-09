package com.grantwiswell.banking.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private int customer_id;
    private int id;
    private double balance;
    private String name;
    private String status;

    public Account(int customer_id, int id, double balance, String name, String status) {
        this.customer_id = customer_id;
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.status = status;
    }

    public String getStatus(){ return status; }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name.toUpperCase() +
                " | Acct#: " + id +
                " | Balance: " + NumberFormat.getCurrencyInstance(Locale.US).format(balance);
    }
}
