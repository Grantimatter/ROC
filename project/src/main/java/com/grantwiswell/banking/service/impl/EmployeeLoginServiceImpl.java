package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.EmployeeLoginDao;
import com.grantwiswell.banking.dao.impl.EmployeeLoginDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Employee;
import com.grantwiswell.banking.service.EmployeeLoginService;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;


public class EmployeeLoginServiceImpl implements EmployeeLoginService {

    private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeLoginServiceImpl.class);
    EmployeeLoginDao employeeLoginDao = new EmployeeLoginDaoImpl();

    @Override
    public Employee employeeLogin(String user_name, String password) {
        if(user_name == null || user_name.length() == 0) throw new BankException("Invalid username...");
        if(password == null || password.length() < 8) throw new BankException("Invalid Password. Password must be at least 8 characters");
        try{
           return employeeLoginDao.employeeLogin(user_name, password);
        } catch (Exception e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }
}
