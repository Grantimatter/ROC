package mechanics.commands;

import interfaces.IAttackable;
import mechanics.entities.Entity;

public class HostileCommands {
    public static void attackCommand(IAttackable attackee, Entity attacker){
        // If there is a weapon equipped, use it to attack the entity being attacked
        if(attacker.getEquippedWeapon() != null){
            attacker.getEquippedWeapon().attack(attackee, attacker);
        }
    }
}
