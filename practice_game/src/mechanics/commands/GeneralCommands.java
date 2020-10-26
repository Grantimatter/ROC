package mechanics.commands;
import items.Inventory;
import mechanics.entities.Player;
import mechanics.entities.enemies.Enemy;
import mechanics.entities.enemies.Warlock;
import messages.GenericMessages;

import java.util.Scanner;

public class GeneralCommands {

    public static Player createPlayer(){
        System.out.print("Enter Player Name : ");

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(scanner.nextLine());
        return player;
    }

    public static Enemy createEnemy(){
        return new Warlock();
    }

    public static void openInventory(Inventory inventory){

    }

    public static void wrapUp(){
        GenericMessages.endMessage();
    }

}
