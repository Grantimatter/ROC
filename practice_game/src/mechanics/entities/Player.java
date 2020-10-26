package mechanics.entities;

import items.weapons.Fist;
import items.weapons.Weapon;

public class Player extends Entity {

    public Player(){
        super(100, "Player");
    }
    public Player(String name){
        super(100, name, new Fist());
    }
    public Player(int health, String name, Weapon weapon){
        super(health, name, new Fist());
    }

    @Override
    public void defeat(Entity attacker) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
