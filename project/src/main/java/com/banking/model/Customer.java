package com.banking.model;

import java.util.Arrays;

public class Customer {
    private int id;
    private int[] accountNumbers;
    private String name;
    private String password;
    private String contactEmail;
    private long contactNumber;

    public Customer(int id, int[] accountNumbers, String name, String contactEmail, long contactNumber) {
        this.id = id;
        this.accountNumbers = accountNumbers;
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

    public Customer(int id, int[] accountNumbers, String name, String password, String contactEmail, long contactNumber) {
        this.id = id;
        this.accountNumbers = accountNumbers;
        this.name = name;
        this.password = password;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(int[] accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

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
                ", accountNumbers=" + Arrays.toString(accountNumbers) +
                ", name='" + name + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
