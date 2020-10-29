package com.player.service.impl;

import com.player.dao.PlayerSearchDAO;
import com.player.dao.impl.PlayerSearchDAOImpl;
import com.player.service.PlayerSearchService;
import exception.BusinessException;
import model.Player;

import java.util.List;

public class PlayerSearchServiceImpl implements PlayerSearchService {

    private PlayerSearchDAO playerSearchDAO = new PlayerSearchDAOImpl();

    @Override
    public List<Player> getAllPlayers() {
        return playerSearchDAO.getAllPlayers();
    }

    @Override
    public Player getPlayerById(int id) throws BusinessException {
        if(id > 99 && id < 1000)
            return playerSearchDAO.getPlayerById(id);
        else
            throw new BusinessException("You have entered an invalid ID, please enter a 3 digit ID.");
    }

    @Override
    public List<Player> getPlayersByName(String name) throws BusinessException {
        return playerSearchDAO.getPlayersByName(name);
    }

    @Override
    public List<Player> getPlayersByAge(int age) throws BusinessException {
        if(age >= 0 && age <= 130)
            return playerSearchDAO.getPlayersByAge(age);
        else
            throw new BusinessException("You have entered an invalid age, please enter an age in the range of 0-130.");
    }

    @Override
    public Player getPlayerByContactNumber(long contact) throws BusinessException {
        return playerSearchDAO.getPlayerByContactNumber(contact);
    }

    @Override
    public List<Player> getPlayersByTeamName(String teamName) throws BusinessException {
        return playerSearchDAO.getPlayersByTeamName(teamName);
    }

    @Override
    public List<Player> getPlayersByGender(String gender) throws BusinessException {
        if(gender != null && gender.matches("[mMfFoO]"))
            return playerSearchDAO.getPlayersByGender(gender);
        else
            throw new BusinessException("You have entered an invalid gender, please input (M/F/O).");
    }
}
