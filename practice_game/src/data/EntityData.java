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

    public void setHealth(int health) { this.health = health; }

    public int getEnergy() { return energy; }

    public void setEnergy(int energy) { this.energy = energy; }

    public int getEnergyRegen() { return energyRegen; }

    public void setEnergyRegen(int energyRegen) { this.energyRegen = energyRegen; }

    public int getBaseDamage() { return baseDamage; }

    public void setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; }

    public int getBaseEnergyDrain() { return baseEnergyDrain; }

    public void setBaseEnergyDrain(int baseEnergyDrain) { this.baseEnergyDrain = baseEnergyDrain; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Entity getTargetEntity() { return targetEntity; }

    public void setTargetEntity(Entity targetEntity) { this.targetEntity = targetEntity; }

    public Inventory getInventory() { return inventory; }

    public void setInventory(Inventory inventory) { this.inventory = inventory; }

    public Weapon getEquippedWeapon() { return equippedWeapon; }

    public void setEquippedWeapon(Weapon equippedWeapon) { this.equippedWeapon = equippedWeapon; }

    @Override
    public String toString() {
        String[] valueNames = new String[] {"Name","Health","Energy","NRG Regen","Weapon"};
        String[] values = new String[] {name, Integer.toString(health),Integer.toString(energy), Integer.toString(energyRegen), equippedWeapon != null ? equippedWeapon.toString() : "None"};
        ScreenFormatter.addString("\n");

        return formatAttributes(valueNames, values, 0);
    }
}
