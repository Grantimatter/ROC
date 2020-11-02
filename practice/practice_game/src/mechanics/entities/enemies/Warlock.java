package mechanics.entities.enemies;

import data.EntityData;
import items.weapons.Stick;

public class Warlock extends Enemy {
    public Warlock(){
        super(new EntityData("Warlock").setHealth(20).setEquippedWeapon(new Stick()));
    }
}
