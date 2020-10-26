package mechanics.entities;

import items.weapons.Weapon;

public class Player extends Entity {

    Weapon weapon;

    public Player(){

    }
    public Player(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public void defeat() {

    }

    public void printPlayer(){
        System.out.println(weapon.toString());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
