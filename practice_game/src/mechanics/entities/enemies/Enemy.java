package mechanics.entities.enemies;

import items.weapons.Weapon;
import mechanics.entities.Entity;

public abstract class Enemy extends Entity {

    public Enemy(int health, String name){
        super(health, name);
    }
    public Enemy(int health, String name, Weapon weapon){
        super(health, name, weapon);
    }

    @Override
    public void defeat(Entity attacker) {
        super.defeat(attacker);
    }
}
