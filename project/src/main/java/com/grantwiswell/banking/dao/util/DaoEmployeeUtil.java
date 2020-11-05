package com.grantwiswell.banking.dao.util;

import com.grantwiswell.banking.dao.impl.EmployeeLoginDaoImpl;
import com.grantwiswell.banking.model.Employee;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoEmployeeUtil {

    private static Logger log = Logger.getLogger(DaoEmployeeUtil.class);

    public static Employee getEmployeeFromResultSet(ResultSet resultSet){
        Employee employee = null;
        try {
            employee = new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("privilege")
            );
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return employee;
    }
}
