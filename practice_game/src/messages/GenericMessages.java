package messages;

public class GenericMessages {

    public static void newGameMessage(){
        System.out.println("Welcome to the game!\nWould you like to see the controls? Y/N");
    }

    public static void helpMessage(){
        System.out.println("[H]elp / ?  : Help (this screen)");
        System.out.println("[R]eload    : Reload");
        System.out.println("[A]ttack    : Attack");
        System.out.println("[H]eal      : Heal");
        System.out.println("[I]nventory : Inventory");

        System.out.println();
    }

    public static void endMessage(){
        System.out.println("Thanks for playing, goodbye!");
    }

    public static void failureMessage(){

    }

}
