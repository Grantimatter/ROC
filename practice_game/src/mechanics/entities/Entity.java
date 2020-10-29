package mechanics.entities;

import data.EntityData;
import formatting.ScreenFormatter;
import interfaces.IAttackable;

abstract public class Entity implements IAttackable {

    protected EntityData data;
    public abstract String getEntityCommand();

    public Entity(EntityData entityData){
        this.data = entityData;
    }

    public EntityData getEntityData(){
        return data;
    }

    public boolean isAlive(){
        return data.getHealth() > 0;
    }

    public void attack(IAttackable attackable){
        if(data.getEquippedWeapon() != null){
            data.getEquippedWeapon().attack(attackable, this);
        }
        else{
            ScreenFormatter.addString(data.getName() + " spends " + data.getBaseEnergyDrain() + " energy to attack "+ ((Entity)attackable).data.getName() + " for " + data.getBaseDamage() + " damage\n");
            attackable.takeDamage(data.getBaseDamage(), this);
            drainEnergy(data.getBaseEnergyDrain());
        }
    }

    public void drainEnergy(int energyDrain){
        data.setEnergy(data.getEnergy() - energyDrain);
    }

    @Override
    public void takeDamage(int damage, Entity attacker) {
        int health = data.getHealth() - damage;
        data.setHealth(health > 0 ? health : 0);
        ScreenFormatter.addString(data.getName()+ " has " +health + " health remaining.\n");
        if(health <= 0) defeat(attacker);
    }

    @Override
    public void defeat(Entity attacker) { ScreenFormatter.addString(data.getName()+" has been defeated by " + attacker.data.getName() + "\n"); }

    @Override
    public String toString() { return data.toString(); }
}
