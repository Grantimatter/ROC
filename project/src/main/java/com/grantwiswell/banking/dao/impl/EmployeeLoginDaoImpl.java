package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.EmployeeLoginDao;
import com.grantwiswell.banking.dao.queries.EmployeeQueries;
import com.grantwiswell.banking.dao.util.DaoEmployeeUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Employee;
import com.grantwiswell.banking.service.impl.util.QueryUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeLoginDaoImpl implements EmployeeLoginDao {

    private static Logger log = Logger.getLogger(EmployeeLoginDaoImpl.class);

    public Employee employeeLogin(String user_name, String password){
        Employee employee = DaoEmployeeUtil.getNextEmployeeFromResultSet(QueryUtil.sendQuery(EmployeeQueries.GET_EMPLOYEE_BY_LOGIN, user_name, password));
        if(employee == null) throw new BankException("Employee credentials not found!");
        return employee;
    }
}
