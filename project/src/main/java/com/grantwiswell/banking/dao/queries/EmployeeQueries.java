package com.grantwiswell.banking.dao.queries;

public class EmployeeQueries {
    public static final String GET_EMPLOYEE_DATA = "SELECT id, name, privilege FROM bank.employee";
    public static final String GET_EMPLOYEE_BY_LOGIN = GET_EMPLOYEE_DATA + " WHERE name ILIKE ? AND password=?";
}
