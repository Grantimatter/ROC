package com.grantwiswell.banking.service;

import com.grantwiswell.banking.model.Employee;

public interface EmployeeLoginService {
    public Employee employeeLogin(String user_name, String password);
}
