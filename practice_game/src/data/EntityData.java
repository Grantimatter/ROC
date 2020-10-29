package data;

import formatting.ScreenFormatter;
import items.Inventory;
import items.weapons.Weapon;
import mechanics.entities.Entity;

import static formatting.StringFormatting.formatAttributes;

public class EntityData {
    protected Weapon equippedWeapon;
    private int health = 100;
    private int energy = 100;
    private int energyRegen = 5;
    private int baseDamage = 2;
    private int baseEnergyDrain = 2;
    private String name;
    private Inventory inventory;
    private Entity targetEntity;

    public EntityData(String name) { this.name = name; }

    public int getHealth() { return health; }

    public EntityData setHealth(int health) { this.health = health; return this;}

    public int getEnergy() { return energy; }

    public EntityData setEnergy(int energy) { this.energy = energy; return this;}

    public int getEnergyRegen() { return energyRegen; }

    public EntityData setEnergyRegen(int energyRegen) { this.energyRegen = energyRegen; return this;}

    public int getBaseDamage() { return baseDamage; }

    public EntityData setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; return this;}

    public int getBaseEnergyDrain() { return baseEnergyDrain; }

    public EntityData setBaseEnergyDrain(int baseEnergyDrain) { this.baseEnergyDrain = baseEnergyDrain; return this;}

    public String getName() { return name; }

    public EntityData setName(String name) { this.name = name; return this;}

    public Entity getTargetEntity() { return targetEntity; }

    public EntityData setTargetEntity(Entity targetEntity) { this.targetEntity = targetEntity; return this;}

    public Inventory getInventory() { return inventory; }

    public EntityData setInventory(Inventory inventory) { this.inventory = inventory; return this;}

    public Weapon getEquippedWeapon() { return equippedWeapon; }

    public EntityData setEquippedWeapon(Weapon equippedWeapon) { this.equippedWeapon = equippedWeapon; return this;}

    @Override
    public String toString() {
        String[] valueNames = new String[] {"Name","Health","Energy","NRG Regen","Weapon"};
        String[] values = new String[] {name, Integer.toString(health),Integer.toString(energy), Integer.toString(energyRegen), equippedWeapon != null ? equippedWeapon.toString() : "None"};
        ScreenFormatter.addString("\n");

        return formatAttributes(valueNames, values, 0);
    }
}
