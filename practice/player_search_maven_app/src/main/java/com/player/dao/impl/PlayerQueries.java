package com.player.dao.impl;

public class PlayerQueries {
    public static final String GET_ALL_PLAYER_COLUMNS = "SELECT id, name, age, gender, teamName, contact FROM roc_revature.player";
    public static final String INSERT_PLAYER = "INSERT INTO roc_revature.player(id, name, age, gender, teamName, contact) VALUES(?,?,?,?,?,?)";
    public static final String GET_PLAYER_BY_ID = GET_ALL_PLAYER_COLUMNS + " WHERE id=?";
    public static final String GET_PLAYER_BY_NAME = GET_ALL_PLAYER_COLUMNS + " WHERE name=?";
    public static final String GET_PLAYER_BY_AGE = GET_ALL_PLAYER_COLUMNS + " WHERE age=?";
    public static final String GET_PLAYER_BY_CONTACT = GET_ALL_PLAYER_COLUMNS + " WHERE contact=?";
    public static final String GET_PLAYER_BY_TEAM_NAME = GET_ALL_PLAYER_COLUMNS + " WHERE teamName=?";
    public static final String GET_PLAYER_BY_GENDER = GET_ALL_PLAYER_COLUMNS + " WHERE gender=?";
    public static final String UPDATE_PLAYER_CONTACT = "UPDATE roc_revature.player SET contact=? WHERE id=?";
    public static final String GET_ALL_PLAYERS = "SELECT * FROM roc_revature.player";
    public static final String DELETE_PLAYER = "DELETE FROM roc_revature.player WHERE id=?";
}
