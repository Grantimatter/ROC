package com.player.dao.impl;

import com.player.dao.PlayerDAO;
import com.player.exception.BusinessException;
import com.player.jdbutil.PostgresSqlConnection;
import com.player.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAOImpl implements PlayerDAO {

    public int createPlayer(Player player) throws BusinessException {
        int c=0;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql = PlayerQueries.INSERT_PLAYER;

            // Prepare the prepared statement
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, player.getId());
            preparedStatement.setString(2, player.getName());
            preparedStatement.setInt(3, player.getAge());
            preparedStatement.setString(4, player.getGender());
            preparedStatement.setString(5, player.getTeamName());
            preparedStatement.setLong(6,player.getContact());

            c = preparedStatement.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e); // TODO take off line in production
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return c;
    }

    public int updatePlayerContact(int id, long newContact) throws BusinessException {
        int c = 0;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.UPDATE_PLAYER_CONTACT);
            preparedStatement.setLong(1, newContact);
            preparedStatement.setInt(2, id);

            c = preparedStatement.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e); // TODO take off line in production
            throw new BusinessException("Inter error occurred.. Kindly contact SYSADMIN");
        }
        return c;
    }

    public void deletePlayer(int id) throws BusinessException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
                    PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.INSERT_PLAYER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e); // TODO take off line in production
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
    }

    public Player getPlayerById(int id) throws BusinessException {
        Player player = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(PlayerQueries.GET_PLAYER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                player = new Player(id,
                        resultSet.getInt("age"),
                        resultSet.getString("name"),
                        resultSet.getString("teamName"),
                        resultSet.getLong("contact"),
                        resultSet.getString("gender"));
            }
            else{
                throw new BusinessException("Invalid ID!... No matching records found for the ID = "+id);
            }
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e); // TODO take off line in production
            throw new BusinessException("Internal error occurred.. Kindly contact SYSADMIN");
        }
        return player;
    }
}
