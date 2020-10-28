package mechanics.encounters;

import mechanics.entities.Entity;
import mechanics.entities.enemies.Enemy;

public class HostileEncounter extends Encounter{

    public HostileEncounter(Entity starterEntity, Enemy targetEnemy){
        super(starterEntity, targetEnemy);
    }

    @Override
    public boolean inProgress() {
        return (starterEntity.isAlive() && targetEntity.isAlive());
    }

    @Override
    public void endEncounter(){
        System.out.println(getVictor() + " has defeated " + getLoser());
    }

    private String getVictor(){
        return starterEntity.isAlive() ? starterEntity.getName() : targetEntity.getName();
    }

    private String getLoser(){
        return starterEntity.isAlive() ? targetEntity.getName() : starterEntity.getName();
    }
}
