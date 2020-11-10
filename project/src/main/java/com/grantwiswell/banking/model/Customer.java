package com.grantwiswell.banking.model;

import com.grantwiswell.banking.util.FormatStrings;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Customer implements Comparable<Customer> {
    private int id;
    private List<Account> accounts;
    private String first_name;
    private String last_name;
    private String password;
    private String contactEmail;
    private String status;
    private long contactNumber;
    private Date dob;

    public Customer(int id, List<Account> accounts, String first_name, String last_name, String contactEmail, long contactNumber, String status, Date dob) {
        this.id = id;
        this.accounts = accounts;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
        this.status = status;
        this.dob = dob;
    }

    public Customer(int id, String first_name, String last_name, String password, String contactEmail, String status) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.contactEmail = contactEmail;
        this.status = status;
    }

    public Customer(String first_name, String last_name, String contactEmail, String password, Date dob, String status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.contactEmail = contactEmail;
        this.dob = dob;
        this.status = status;
    }

    public Customer(int id, List<Account> accounts, String first_name, String last_name, String password, String contactEmail, long contactNumber, String status, Date dob) {
        this(id, accounts, first_name, last_name, contactEmail, contactNumber, status, dob);
        this.password = password;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
        return String.format(" Name: %s, %s \u2502 Email: %s \u2502 Number: %s \u2502 Status: %s \u2502 Birthday: %s \u2502 ID: %d",
                last_name, first_name, contactEmail,
                (contactNumber > 100000 ? (String.format(FormatStrings.formatPhoneNumber(contactNumber))) : "N/A"),
                status, new SimpleDateFormat("MMMM dd, yyyy").format(dob),
                id);
    }

    @Override
    public int compareTo(Customer o) {
        return this.getLast_name().compareTo(o.getLast_name());
    }
}
