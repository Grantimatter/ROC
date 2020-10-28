package mechanics.entities;

import data.PlayerData;
import items.weapons.Fist;
import items.weapons.Weapon;
import mechanics.commands.GameFlow;
import mechanics.commands.GeneralCommands;

public class Player extends Entity {

    private PlayerData playerData;

    public Player(){
        super(100, "Player");
        playerData = new PlayerData();
    }
    public Player(String name){
        super(100, name, new Fist());
    }
    public Player(int health, String name, Weapon weapon){
        super(health, name, new Fist());
    }

    @Override
    public void defeat(Entity attacker) {
        super.defeat(attacker);
        GameFlow.playerDeath();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
