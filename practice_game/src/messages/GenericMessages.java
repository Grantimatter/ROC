package messages;

import formatting.StringFormatting;

public class GenericMessages {

    public static void newGameMessage(){
        System.out.println("Welcome to the game!\nWould you like to see the controls? Y/N");
    }

    public static void helpMessage(){
        String[] leftSide = new String[]{"[H]elp / ?", "[A]ttack", "[H]eal", "[I]nventory"};
        String[] rightside = new String[]{"Help screen (this screen)", "Use weapon", "Use healing item", "Open inventory"};

        System.out.println(StringFormatting.formatAttributes(leftSide, rightside, 0));
    }

    public static void endMessage(){
        System.out.println("Thanks for playing, goodbye!");
    }

    public static void failureMessage(){

    }

}
