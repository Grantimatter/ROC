package mechanics.commands;

import items.weapons.Stick;
import mechanics.entities.Player;
import mechanics.entities.enemies.Enemy;
import mechanics.entities.enemies.Warlock;
import messages.GenericMessages;

public class GeneralCommands {

    public static Player createPlayer(){
        Player player = new Player(new Stick());
        return player;
    }

    public static Enemy createEnemy(){
        return new Warlock();
    }

    public static void wrapUp(){
        GenericMessages.endMessage();
    }

}
