package mechanics.entities;

import interfaces.IAttackable;
import items.Inventory;
import items.tools.ItemTool;
import items.weapons.Weapon;

import static formatting.StringFormatting.formatAttributes;

abstract public class Entity implements IAttackable {
    protected String name;
    protected int health;
    protected int energy = 100;
    protected int energyRegen = 5;
    protected Weapon equippedWeapon;
    protected ItemTool equippedTool;
    protected Inventory inventory;

    public Entity(){

    }
    public Entity(int health, String name){
        this.health = health;
        this.name = name;
    }
    public Entity(int health, String name, Weapon weapon)
    {
        this(health, name);
        this.equippedWeapon = weapon;
    }

    public void drainEnergy(int energyDrain){
        energy -= energyDrain;
    }

    public int getEnergy(){
        return energy;
    }

    public Inventory getInventory(){
        return inventory;
    }

    @Override
    public void takeDamage(int damage, Entity attacker) {
        health -= damage;
        System.out.print(name+" has taken "+damage+ " damage and now has " +health + " remaining.");
        if(health <= 0){
            defeat(attacker);
        }
    }

    @Override
    public String toString() {
        //int indent = 15;
        //return formatAttribute("Name",name,indent) + "\nHealth   : "+health + "\nEnergy    : "+energy + "\nEnergy Regen    : "+energyRegen + "\n\nWeapon       : "+weapon.toString();
        String[] valueNames = new String[] {"Name","Health","Energy","NRG Regen","Weapon"};
        String[] values = new String[] {name, Integer.toString(health),Integer.toString(energy), Integer.toString(energyRegen), equippedWeapon.toString()};

        return formatAttributes(valueNames, values, 0);
    }
}
