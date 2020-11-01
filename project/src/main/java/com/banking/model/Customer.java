package com.banking.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
    private int id;
    private List<Account> accounts;
    private String name;
    private String password;
    private String contactEmail;
    private long contactNumber;

    public Customer(int id, List<Account> accounts, String name, String contactEmail, long contactNumber) {
        this.id = id;
        this.accounts = accounts;
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
    }

    public Customer(int id, String name, String password, String contactEmail, long contactNumber) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
    }

    public Customer(int id, List<Account> accounts, String name, String password, String contactEmail, long contactNumber) {
        this(id, accounts, name, contactEmail, contactNumber);
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Account> getAccounts() { return accounts; }

    public void setAccounts(List<Account> accounts) { this.accounts = accounts; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "id=" + id +
                ", accounts=" + accounts.toString() +
                ", name='" + name + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
