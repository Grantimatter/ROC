package mechanics.entities.enemies;

import data.EntityData;
import items.weapons.Weapon;
import mechanics.entities.Entity;

public abstract class Enemy extends Entity {

    public Enemy(EntityData entityData) {
        super(entityData);
    }

    @Override
    public void defeat(Entity attacker) {
        super.defeat(attacker);
    }

    @Override
    public String getEntityCommand() {
        if(data.getEnergy() > 0) {
            return "attack";
        }
        else{
            return "pass";
        }
    }
}
