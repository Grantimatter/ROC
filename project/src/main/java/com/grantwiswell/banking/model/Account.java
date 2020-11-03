package com.grantwiswell.banking.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private int customer_id;
    private int number;
    private double balance;
    private String name;

    public Account(int customer_id, int number, double balance, String name) {
        this.customer_id = customer_id;
        this.number = number;
        this.balance = balance;
        this.name = name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
                " | Acct# : " + number +
                " | Balance : " + NumberFormat.getCurrencyInstance(Locale.US).format(balance);
    }
}
