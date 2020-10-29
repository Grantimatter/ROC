package items.weapons;

import com.sun.javafx.binding.StringFormatter;
import formatting.ScreenFormatter;
import formatting.StringFormatting;
import interfaces.IAttackable;
import items.Item;
import mechanics.entities.Entity;

public abstract class Weapon extends Item {
    protected int damage;
    protected int energyCost;

    public Weapon(){

    }
    public Weapon(String name, int damage, int energyCost, int durability, int value){
        super(name, value, durability);
        this.damage = damage;
        this.energyCost = energyCost;
    }

    public void attack(IAttackable attackable, Entity attacker){
        if(attacker.getEntityData().getEnergy() > energyCost){
            //System.out.println(attacker.getName() + " spends " + energyCost + " energy to attack "+ ((Entity)attackable).getName() + " for " + damage + " damage");
            ScreenFormatter.addString(attacker.getEntityData().getName() + " spends " + energyCost + " energy to attack "+ ((Entity)attackable).getEntityData().getName() + " for " + damage + " damage\n");
            attackable.takeDamage(damage, attacker);
            attacker.drainEnergy(energyCost);
        }
    }

    public int getDamage(){
        return damage;
    }

    @Override
    public String toString() {
        String[] valueNames = new String[] {"Damage","NRG Cost"};
        String[] values = new String[] {Integer.toString(damage), Integer.toString(energyCost)};
        return super.toString() + StringFormatting.formatAttributes(valueNames, values, 0);
    }
}
