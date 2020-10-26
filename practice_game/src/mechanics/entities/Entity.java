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
    protected Entity targetEntity;

    public Entity(){
        inventory = new Inventory();
    }
    public Entity(int health, String name){
        this();
        this.health = health;
        this.name = name;
    }
    public Entity(int health, String name, Weapon weapon)
    {
        this(health, name);
        inventory.addWeapon(weapon);
        this.equippedWeapon = weapon;
    }

    public void announce(){
        System.out.println("A "+name + " has approached, holding a(n) "+getEquippedWeapon().getName() + ". What do you do?\n");
    }

    public void drainEnergy(int energyDrain){
        energy -= energyDrain;
    }

    public int getEnergy(){
        return energy;
    }

    public int getHealth(){
        return health;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public String getName(){
        return name;
    }

    public Weapon getEquippedWeapon(){
        return equippedWeapon;
    }

    public Entity getTargetEntity(){
        return targetEntity;
    }
    public void setTargetEntity(Entity targetEntity){
        this.targetEntity = targetEntity;
    }

    @Override
    public void takeDamage(int damage, Entity attacker) {
        health -= damage;
        System.out.print(name+" has taken "+damage+ " damage and now has " +health + " health remaining.\n");
        if(health <= 0){
            defeat(attacker);
        }
    }

    @Override
    public void defeat(Entity attacker) {
        System.out.print(name+" has been defeated by " + attacker.getName() + "\n");
    }

    @Override
    public String toString() {
        //int indent = 15;
        //return formatAttribute("Name",name,indent) + "\nHealth   : "+health + "\nEnergy    : "+energy + "\nEnergy Regen    : "+energyRegen + "\n\nWeapon       : "+weapon.toString();
        String[] valueNames = new String[] {"Name","Health","Energy","NRG Regen","Weapon"};
        String[] values = new String[] {name, Integer.toString(health),Integer.toString(energy), Integer.toString(energyRegen), equippedWeapon != null ? equippedWeapon.toString() : "None"};
        System.out.println();

        return formatAttributes(valueNames, values, 0);
    }
}
