package messages;

import formatting.StringFormatting;
import mechanics.entities.Player;

import java.util.Scanner;

public class GenericMessages {

    public static void newGameMessage(Player player){
        System.out.println("Welcome to the game, " + player.getName() + "!\nWould you like to see the Help Screen? Y/N");
    }

    public static void helpMessage(){
        String[] leftSide = new String[]{"HELP SCREEN","[H]elp / ?", "[A]ttack", "[H]eal", "[I]nventory"};
        String[] rightSide = new String[]{"Help screen", "Use weapon", "Use healing item", "Open inventory"};

        System.out.println(StringFormatting.formatAttributes(leftSide, rightSide, 0) + "\n\nInsert anything to continue");

        new Scanner(System.in).nextLine();
    }

    public static void winMessage(){
        Gui.clearConsole();
        System.out.println("You have won the game, congratulations!");
    }

    public static void failMessage(){
        Gui.clearConsole();
        System.out.println("You have lost the game!");
    }

    public static void endMessage(){
        Gui.clearConsole();
        System.out.println("Thanks for playing, goodbye!");
    }

}
