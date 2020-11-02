import mechanics.commands.ReadInput;
import mechanics.encounters.Encounter;
import mechanics.encounters.EncounterGenerator;
import mechanics.entities.Player;
import messages.GenericMessages;

import static mechanics.commands.GeneralCommands.createPlayer;

public class MainLoop {

    private static Player player;
    private static int loops;

    public static void main(String[] args) {
        // Before the game loop initiates
        beforeFirstLoop();
        do{
            beginLoop();
            loops++;
        }while(runGame());

        // Once game has ended
        if(player.isAlive()){
            GenericMessages.winMessage();
        }
        else{
            GenericMessages.failMessage();
        }
    }

    public static void beforeFirstLoop(){
        player = createPlayer();
        GenericMessages.newGameMessage(player);
        // Ask if instructions are required
        if(ReadInput.ynRead()){
            GenericMessages.helpMessage();
        }
    }

    public static void beginLoop(){
        Encounter encounter = EncounterGenerator.generateRandomEncounter(player);
        if(encounter != null){
            encounter.startEncounter();
        }
    }

    public static boolean runGame(){
        return loops < 100 && player.isAlive();
    }

    public static void getCommandInput(){
        player.getEntityCommand();
        //ReadInput.readUserInput(player);
    }
}
