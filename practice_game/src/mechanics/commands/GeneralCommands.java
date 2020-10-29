package mechanics.commands;
import data.PlayerData;
import formatting.StringFormatting;
import items.Inventory;
import mechanics.entities.Player;
import messages.GenericMessages;
import messages.Gui;
import messages.PlayerMessages;

import java.util.Scanner;

public class GeneralCommands {

    public static Player createPlayer(){
        System.out.print("Enter Player Name : ");

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(new PlayerData(StringFormatting.capEveryWord(scanner.nextLine()), 10));
        return player;
    }

    public static void openInventory(Inventory inventory){
        PlayerMessages.inventoryMessage(inventory);
    }

    public static void wrapUp(){
        GenericMessages.endMessage();
    }

}
