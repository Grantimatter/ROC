package com.grantwiswell.banking.service.impl.util;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import org.apache.log4j.Logger;
import sun.security.provider.certpath.PKIXTimestampParameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class QueryUtil {

    private static Logger log = Logger.getLogger(QueryUtil.class);

    public static ResultSet sendQuery(String sql, Object... objects) throws BankException {
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            return prepareFromObjectList(connection.prepareStatement(sql), objects).executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return null;
    }

    public static int sendUpdate(String sql, Object... objects) {
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            return prepareFromObjectList(connection.prepareStatement(sql), objects).executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return 0;
    }

    public static PreparedStatement prepareFromObjectList(PreparedStatement preparedStatement, Object[] objects) {
        try {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] instanceof Integer) {
                    preparedStatement.setInt(i + 1, (int) objects[i]);
                } else if (objects[i] instanceof String) {
                    preparedStatement.setString(i + 1, (String) objects[i]);
                } else if (objects[i] instanceof Double) {
                    preparedStatement.setDouble(i + 1, (double) objects[i]);
                } else if (objects[i] instanceof Long) {
                    preparedStatement.setLong(i + 1, (long) objects[i]);
                } else if (objects[i] instanceof java.sql.Date) {
                    preparedStatement.setDate(i + 1, (java.sql.Date) objects[i]);
                } else if(objects[i] instanceof Timestamp){
                    preparedStatement.setTimestamp(i + 1, (Timestamp) objects[i]);
                }
            }
            return preparedStatement;

        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

}
