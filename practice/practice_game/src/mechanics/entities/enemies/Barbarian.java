package mechanics.entities.enemies;

import data.EntityData;
import items.weapons.Axe;

public class Barbarian extends Enemy {
    public Barbarian(){
        super(new EntityData("Barbarian").setHealth(20).setEquippedWeapon(new Axe()));
    }
}
