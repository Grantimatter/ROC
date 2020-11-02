package interfaces;

import mechanics.entities.Entity;

public interface IAttackable {
    void takeDamage(int damage, Entity attacker);
    void defeat(Entity attacker);
}
