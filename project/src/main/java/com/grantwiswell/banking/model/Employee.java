package com.grantwiswell.banking.model;

public class Employee {
    private int id;
    private int pin;
    private String name;
    private String privilege;

    public Employee(int id, int pin, String name, String privilege) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.privilege = privilege;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", pin=" + pin +
                ", name='" + name + '\'' +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
