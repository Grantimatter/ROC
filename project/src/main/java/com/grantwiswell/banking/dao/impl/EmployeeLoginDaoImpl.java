package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.EmployeeLoginDao;
import com.grantwiswell.banking.dao.queries.EmployeeQueries;
import com.grantwiswell.banking.dao.util.DaoEmployeeUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Employee;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeLoginDaoImpl implements EmployeeLoginDao {

    private static Logger log = Logger.getLogger(EmployeeLoginDaoImpl.class);

    public Employee employeeLogin(String user_name, String password){
        Employee employee = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(EmployeeQueries.GET_EMPLOYEE_BY_LOGIN);
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                employee = DaoEmployeeUtil.getEmployeeFromResultSet(resultSet);
            }
            else{
                throw new BankException("Employee username and password combo not found...");
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return employee;
    }
}
