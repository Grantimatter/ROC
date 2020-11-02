package com.grantwiswell.banking.model;

import java.util.List;

public class Customer {
    private int id;
    private List<Account> accounts;
    private String first_name;
    private String last_name;
    private String password;
    private String contactEmail;
    private long contactNumber;

    public Customer(int id, List<Account> accounts, String first_name, String last_name, String contactEmail, long contactNumber) {
        this.id = id;
        this.accounts = accounts;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
    }

    public Customer(int id, String name, String password, String contactEmail, long contactNumber) {
        this.id = id;
        this.first_name = name;
        this.last_name = name;
        this.password = password;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
    }

    public Customer(int id, List<Account> accounts, String first_name, String last_name, String password, String contactEmail, long contactNumber) {
        this(id, accounts, first_name, last_name, contactEmail, contactNumber);
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Account> getAccounts() { return accounts; }

    public void setAccount(Account account) {
        if(accounts.contains(account)){
            accounts.set(accounts.indexOf(account), account);
        }
    }

    public void setAccounts(List<Account> accounts) { this.accounts = accounts; }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setFirst_name(String name) { this.first_name = name; }

    public void setLast_name(String name) {
        this.first_name = name;
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
                ", name='" + first_name + " " + last_name + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
