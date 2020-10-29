package com.player.main;

import com.player.service.PlayerSearchService;
import com.player.service.impl.PlayerSearchServiceImpl;
import exception.BusinessException;
import model.Player;

import java.util.List;
import java.util.Scanner;

public class PlayerMain {
    public static void main(String[] args) {
        PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the player search");
        System.out.println("------------------------------------------");
        int ch = 0;
        do{
            System.out.println("Player Search Menu");
            System.out.println("==================");
            System.out.println("1) By Id");
            System.out.println("2) By Name");
            System.out.println("3) By Age");
            System.out.println("4) By Gender");
            System.out.println("5) By Contact");
            System.out.println("6) By Team Name");
            System.out.println("7) All Players");
            System.out.println("8) EXIT");
            System.out.println("==================");
            System.out.println("Please select an action (1-8) :D");
            try{
                ch = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e){

            }

            switch(ch){
                case 1: System.out.println("Please enter player ID to find a matching player");
                        try{
                            int id = Integer.parseInt(scanner.nextLine());
                            Player player = playerSearchService.getPlayerById(id);
                            System.out.println("Player with ID : "+id+" found. Printing Player...\n" + player.toString());
                        } catch(NumberFormatException | BusinessException e){
                            System.out.println("ID should be a whole number only, please try entering another ID");
                        }
                    break;
                case 2: System.out.println("Please enter player name to find matching players");
                        try{
                            String name = scanner.nextLine();
                            List<Player> playerList = playerSearchService.getPlayersByName(name);
                            System.out.println("Player(s) found with the name "+name+". Printing all...");
                            for (Player p:playerList){
                                System.out.println(p);
                            }
                        } catch (BusinessException e) {
                            System.out.println(e.getMessage());
                        }
                    break;
                case 3: System.out.println("Please enter player age to find matching players");
                    try{
                        int age = Integer.parseInt(scanner.nextLine());
                        List<Player> playerList = playerSearchService.getPlayersByAge(age);
                        System.out.println("Player(s) found with the age "+age+". Printing all...");
                        for (Player p:playerList){
                            System.out.println(p);
                        }
                    } catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: System.out.println("Please enter M/F/O for gender to find matching players");
                    try{
                        String gender = scanner.nextLine();
                        List<Player> playerList = playerSearchService.getPlayersByGender(gender.toUpperCase());
                        System.out.println("Player(s) found with the age "+gender+". Printing all...");
                        for (Player p:playerList){
                            System.out.println(p);
                        }
                    } catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5: System.out.println("Please enter a contact number to find a matching player");
                    try{
                        long contact = Long.parseLong(scanner.nextLine());
                        Player player = playerSearchService.getPlayerByContactNumber(contact);
                        System.out.println("Player found with the contact "+contact+". Printing all...");
                        System.out.println(player);
                    } catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6: System.out.println("Please enter a team name to find matching players");
                    try{
                        String teamName = scanner.nextLine();
                        List<Player> playerList = playerSearchService.getPlayersByTeamName(teamName);
                        System.out.println("Player(s) found with the team name "+teamName+". Printing all...");
                        for (Player p:playerList){
                            System.out.println(p);
                        }
                    } catch (BusinessException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7: System.out.println("Fetching all players from the database");
                    try{
                        List<Player> playerList= playerSearchService.getAllPlayers();
                        if(playerList != null && playerList.size() > 0){
                            System.out.println(playerList.size() + " players found in the database, printing all...");
                            for(Player p:playerList){
                                System.out.println(p);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 8: System.out.println("Thank you for using the search, please come again soon!");

                    break;
                default: System.out.println("Incorrect choice, please select (1-8)");
                    break;
            }
        }while(ch != 8);
    }
}
