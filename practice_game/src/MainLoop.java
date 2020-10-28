import mechanics.commands.ReadInput;
import mechanics.encounters.Encounter;
import mechanics.encounters.EncounterGenerator;
import mechanics.entities.Player;
import messages.GenericMessages;
import messages.Gui;

import static mechanics.commands.GeneralCommands.createPlayer;

public class MainLoop {

    private static boolean runGame = true;
    private static Player player;

    public static void main(String[] args) {
        // Before the game loop initiates
        beforeFirstLoop();
        do{
            beginLoop();
        }while(runGame);

        // Once game has ended
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
        Gui.displayGui();
        Encounter encounter = EncounterGenerator.generateRandomEncounter(player);
        if(encounter != null){
            encounter.startEncounter();
        }
    }

    public static void getCommandInput(){
        ReadInput.readUserInput(player);
    }
}
