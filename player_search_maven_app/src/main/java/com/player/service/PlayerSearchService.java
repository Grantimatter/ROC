package com.player.service;

import com.player.exception.BusinessException;
import com.player.model.Player;
import java.util.List;

public interface PlayerSearchService {
    public List<Player> getAllPlayers();
    public Player getPlayerById(int id) throws BusinessException;
    public List<Player> getPlayersByName(String name) throws BusinessException;
    public List<Player> getPlayersByAge(int age) throws BusinessException;
    public Player getPlayerByContactNumber(long contact) throws BusinessException;
    public List<Player> getPlayersByTeamName(String teamName) throws BusinessException;
    public List<Player> getPlayersByGender(String gender) throws BusinessException;
}
