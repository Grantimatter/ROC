import mechanics.commands.ReadInput;
import mechanics.entities.Player;
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
        // Before the game loop initiates
        beforeFirstLoop();
        do{
            beginLoop();
            endLoop();
        }while(runGame);
        // Once game has ended
        endGame();
    }

    public static void beforeFirstLoop(){
        player = createPlayer();
        // Print player information
        //System.out.println(player.toString());
        GenericMessages.newGameMessage();
        // Ask if instructions are required
        if(ReadInput.ynRead(player)){
            GenericMessages.helpMessage();
        }
    }

    public static void beginLoop(){
        Gui.displayGui();
        System.out.println("Input your command");
        ReadInput.read(player);
    }

    public static void endLoop(){
        loops++;
    }

    public static void endGame(){
        GenericMessages.endMessage();
    }

}
