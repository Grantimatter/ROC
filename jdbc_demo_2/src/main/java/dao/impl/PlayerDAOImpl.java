package dao.impl;

import dao.PlayerDAO;
import exception.BusinessException;
import jdbutil.PostgresSqlConnection;
import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAOImpl implements PlayerDAO {

    public int createPlayer(Player player) throws BusinessException {
        int c=0;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            String sql =
                    "INSERT INTO roc_revature.player(id, name, age, gender, teamName, contact) "
                            + "VALUES(?,?,?,?,?,?)";

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
            String sql = "UPDATE roc_revature.player SET contact=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
            String sql = "DELETE FROM roc_revature.player WHERE id=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
            String sql = "select name, age, gender, teamName, contact from roc_revature.player where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
