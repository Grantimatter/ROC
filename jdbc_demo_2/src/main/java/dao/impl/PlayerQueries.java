package dao.impl;

public class PlayerQueries {
    public static final String INSERT_PLAYER="INSERT INTO roc_revature.player(id, name, age, gender, teamName, contact) VALUES(?,?,?,?,?,?)";
    public static final String GET_PLAYER_BY_ID="SELECT name, age, gender, teamName, contact FROM roc_revature.player WHERE id=?";
    public static final String UPDATE_PLAYER_CONTACT="UPDATE roc_revature.player SET contact=? WHERE id=?";
    public static final String DELETE_PLAYER="DELETE FROM roc_revature.player WHERE id=?";
}
