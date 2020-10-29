package com.player.dao.impl;

import com.player.dao.PlayerSearchDAO;
import exception.BusinessException;
import jdbutil.PostgresSqlConnection;
import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerSearchDAOImpl implements PlayerSearchDAO {
    private static Player getPlayerFromResultSet(ResultSet resultSet) {
        Player player = null;
        try {
            player = new Player(resultSet.getInt("id"),
                    resultSet.getInt("age"),
                    resultSet.getString("name"),
                    resultSet.getString("teamName"),
                    resultSet.getLong("contact"),
                    resultSet.getString("gender"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> playerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(PlayerQueries.GET_ALL_PLAYERS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                playerList.add(getPlayerFromResultSet(resultSet));
            }
            return playerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Player getPlayerById(int id) throws BusinessException {
        Player player = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.GET_PLAYER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                player = getPlayerFromResultSet(resultSet);
            } else {
                throw new BusinessException("Invalid ID!... No matching records found for the ID = " + id);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return player;
    }

    @Override
    public List<Player> getPlayersByName(String name) throws BusinessException {
        List<Player> playerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.GET_PLAYER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                playerList.add(getPlayerFromResultSet(resultSet));
            }
            if (playerList == null || playerList.size() < 1) {
                throw new BusinessException("Invalid Name!... No matching records found for the name = " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return playerList;
    }

    @Override
    public List<Player> getPlayersByAge(int age) throws BusinessException {
        List<Player> playerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.GET_PLAYER_BY_AGE);
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                playerList.add(getPlayerFromResultSet(resultSet));
            }
            if (playerList == null || playerList.size() < 1) {
                throw new BusinessException("Invalid Age!... No matching records found for the age = " + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return playerList;
    }

    @Override
    public Player getPlayerByContactNumber(long contact) throws BusinessException {
        Player player = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.GET_PLAYER_BY_CONTACT);
            preparedStatement.setLong(1, contact);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                player = getPlayerFromResultSet(resultSet);
            } else {
                throw new BusinessException("Invalid Contact!... No matching records found for the contact number = " + contact);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return player;
    }

    @Override
    public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
        List<Player> playerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.GET_PLAYER_BY_TEAM_NAME);
            preparedStatement.setString(1, teamName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                playerList.add(getPlayerFromResultSet(resultSet));
            }
            if (playerList == null || playerList.size() < 1) {
                throw new BusinessException("Invalid Team!... No matching records found for the team name = " + teamName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return playerList;
    }

    @Override
    public List<Player> getPlayersByGender(String gender) throws BusinessException {
        List<Player> playerList = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.GET_PLAYER_BY_GENDER);
            preparedStatement.setString(1, gender);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                playerList.add(getPlayerFromResultSet(resultSet));
            }
            if (playerList == null || playerList.size() < 1) {
                throw new BusinessException("Invalid Gender!... No matching records found for the gender = " + gender);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return playerList;
    }
}
