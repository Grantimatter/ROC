package com.grantwiswell.banking.model;

public class Employee {
    private int id;
    private String name;
    private String privilege;

    public Employee(int id, String name, String privilege) {
        this.id = id;
        this.name = name;
        this.privilege = privilege;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "User: " + name
                + " | Privilege: " + privilege.toUpperCase()
                + " | Employee ID: " + id;
    }
}
