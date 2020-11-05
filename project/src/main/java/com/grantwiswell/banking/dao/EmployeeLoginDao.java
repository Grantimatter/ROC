package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.model.Employee;

public interface EmployeeLoginDao {
    public Employee employeeLogin(String user_name, String password);
}
