import java.util.Scanner;

import items.weapons.Stick;
import items.weapons.Weapon;
import mechanics.commands.GeneralCommands;
import mechanics.commands.ReadInput;
import mechanics.entities.Player;
import mechanics.entities.enemies.Enemy;
import messages.GenericMessages;
import messages.Gui;

import static mechanics.commands.GeneralCommands.createEnemy;
import static mechanics.commands.GeneralCommands.createPlayer;

public class MainLoop {

    private static boolean runGame = true;
    private static int loops;
    private static boolean ynInput;
    private static Player player;

    public static void main(String[] args) {

        Stick stick = new Stick();
        Enemy enemy = createEnemy();
        System.out.println("Stick : "+stick.toString());
        stick.attack(enemy);

        beforeFirstLoop();
        do{
            beginLoop();
            player.printPlayer();
            endLoop();
        }while(runGame);
        endGame();
    }

    public static void beforeFirstLoop(){
        player = createPlayer();
        System.out.println("Printing player");
        player.printPlayer();

        GenericMessages.newGameMessage();
        if(ReadInput.ynRead()){
            GenericMessages.helpMessage();
        }
    }

    public static void beginLoop(){
        Gui.displayGui();
        System.out.println("Input your command");
        ReadInput.read();
    }

    public static void endLoop(){
        loops++;
    }

    public static void terminate(){
        runGame = false;
    }

    public static void endGame(){
        GenericMessages.endMessage();
    }

}
