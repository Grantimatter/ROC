import mechanics.commands.GeneralCommands;
import mechanics.commands.ReadInput;
import mechanics.entities.Entity;
import mechanics.entities.Player;
import mechanics.entities.enemies.Enemy;
import mechanics.entities.enemies.Warlock;
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
        //System.out.println(warlock.toString());
        // Print player information
        //System.out.println(player.toString());
        GenericMessages.newGameMessage(player);

        // Ask if instructions are required
        if(ReadInput.ynRead()){
            GenericMessages.helpMessage();
        }
    }

    public static void beginLoop(){
        Gui.displayGui();

        Warlock warlock = new Warlock();
        beginEncounter(warlock);

        //getCommandInput();
    }

    public static void getCommandInput(){
        System.out.println("Input your command");
        ReadInput.read(player);
    }

    public static void beginEncounter(Entity entity){
        boolean encounter = true;
        entity.announce();
        player.setTargetEntity(entity);

        do{
            if(entity instanceof Enemy){
                if(entity.getHealth() > 0){
                    getCommandInput();
                }
                else{
                    encounter = false;
                }
            }
        }while(encounter);
    }

    public static void endLoop(){
        loops++;
    }

    public static void endGame(){

    }
}
