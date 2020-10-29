package mechanics.entities;

import data.PlayerData;
import formatting.ScreenFormatter;
import items.weapons.Weapon;
import mechanics.commands.GameFlow;
import mechanics.commands.ReadInput;

public class Player extends Entity {

    public static Player instance;
    private PlayerData playerData;

    public Player(PlayerData playerData){
        super(playerData);
        this.playerData = playerData;
        instance = this;
    }

    @Override
    public PlayerData getEntityData() {
        return playerData;
    }

    @Override
    public String getEntityCommand() {
        ScreenFormatter.refreshScreen(this, data.getTargetEntity());
        String command = ReadInput.readUserInput(this);
        return command;
    }

    @Override
    public void defeat(Entity attacker) {
        super.defeat(attacker);
        GameFlow.playerDeath();
    }

    @Override
    public String toString() {
        return playerData.toString();
    }
}
