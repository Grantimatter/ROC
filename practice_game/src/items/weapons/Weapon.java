package items.weapons;

import interfaces.IAttackable;

public abstract class Weapon {
    protected int damage;
    protected String name;

    public Weapon(){

    }
    public Weapon(int damage, String name){
        this.damage = damage;
        this.name = name;
    }

    public void attack(IAttackable attackable){
        attackable.takeDamage(damage);
    }

    public int getDamage(){
        return damage;
    }

    @Override
    public String toString() {
        return "Weapon : "+name+" Damage : "+damage;
    }
}
