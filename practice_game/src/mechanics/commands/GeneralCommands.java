package mechanics.commands;
import formatting.StringFormatting;
import items.Inventory;
import mechanics.entities.Player;
import mechanics.entities.enemies.Enemy;
import mechanics.entities.enemies.Warlock;
import messages.GenericMessages;
import messages.PlayerMessages;

import java.util.Scanner;

public class GeneralCommands {

    public static Player createPlayer(){
        System.out.print("Enter Player Name : ");

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(StringFormatting.capEveryWord(scanner.nextLine()));
        return player;
    }

    public static void openInventory(Inventory inventory){
        PlayerMessages.inventoryMessage(inventory);
    }

    public static void wrapUp(){
        GenericMessages.endMessage();
    }

}
