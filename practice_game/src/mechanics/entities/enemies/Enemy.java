package mechanics.entities.enemies;

import mechanics.entities.Entity;

public abstract class Enemy extends Entity {
    public Enemy(int health, String name){
        super(health, name);
    }

    @Override
    public void defeat(Entity attacker) {

    }
}
