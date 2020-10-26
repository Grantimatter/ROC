package mechanics.entities;

import interfaces.IAttackable;

abstract public class Entity implements IAttackable {
    protected int health;
    protected String name;

    public Entity(){

    }
    public Entity(int health, String name){
        this.health = health;
        this.name = name;
    }

    public Entity(int health){
        this.health = health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        System.out.print(name+" has taken "+damage+ " damage and now has " +health + " remaining.");
        if(health <= 0){
            defeat();
        }
    }

    @Override
    public String toString() {
        return "Name : "+name + "\nHealth : "+health;
    }
}
