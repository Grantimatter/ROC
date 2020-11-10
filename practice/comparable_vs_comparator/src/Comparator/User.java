package Comparator;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class User implements Comparable<User>{

    private int age;
    private String name;
    private double balance;

    public User(int age, String name, double balance) {
        this.age = age;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public int compareTo(User o) {
        return this.getAge() - o.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Age: %d | Balance: %s", name, age, NumberFormat.getCurrencyInstance(Locale.US).format(balance));
    }
}
