import mechanics.commands.ReadInput;
import mechanics.encounters.Encounter;
import mechanics.encounters.EncounterGenerator;
import mechanics.encounters.HostileEncounter;
import mechanics.entities.Player;
import mechanics.entities.enemies.Warlock;
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

        //Warlock warlock = new Warlock();
        //new HostileEncounter(player, warlock).startEncounter();
    }

    public static void beginLoop(){
        Gui.displayGui();
        Encounter encounter = EncounterGenerator.generateRandomEncounter(player);
        if(encounter != null){
            encounter.startEncounter();
        }
        //beginEncounter(player, warlock);
    }

    public static void getCommandInput(){

        ReadInput.read(player);
    }
}
