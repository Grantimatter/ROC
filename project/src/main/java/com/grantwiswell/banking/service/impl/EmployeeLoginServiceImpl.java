package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.EmployeeLoginDao;
import com.grantwiswell.banking.dao.impl.EmployeeLoginDaoImpl;
import com.grantwiswell.banking.model.Employee;
import com.grantwiswell.banking.service.EmployeeLoginService;
import org.apache.log4j.Logger;


public class EmployeeLoginServiceImpl implements EmployeeLoginService {

    private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeLoginServiceImpl.class);
    EmployeeLoginDao employeeLoginDao = new EmployeeLoginDaoImpl();

    @Override
    public Employee employeeLogin(String user_name, String password) {
        Employee employee = null;
        try{
           employee = employeeLoginDao.employeeLogin(user_name, password);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return employee;
    }
}
