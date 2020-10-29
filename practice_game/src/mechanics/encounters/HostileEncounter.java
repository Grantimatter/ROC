package mechanics.encounters;

import mechanics.entities.Entity;
import mechanics.entities.EntityMethods;
import mechanics.entities.enemies.Enemy;

public class HostileEncounter extends Encounter{

    public HostileEncounter(Entity[] starterEntities, Entity... approachingEntities){
        super(starterEntities, approachingEntities);
    }

    @Override
    public boolean inProgress() {
        Entity[] targets = new Entity[approachingEntities.size()];
        for(int i = 0; i < targets.length; i++){
            targets[i] = approachingEntities.get(i);
        }

        return (EntityMethods.areAlive(targets));
    }

    private String getVictor(){
        return EntityMethods.areAlive((Entity[])startingEntities.toArray()) ? getEntityNames((Entity[])startingEntities.toArray()) : getEntityNames((Entity[])approachingEntities.toArray());
    }

    private String getLoser(){
        return EntityMethods.areAlive((Entity[])startingEntities.toArray()) ? getEntityNames((Entity[])approachingEntities.toArray()) : getEntityNames((Entity[])startingEntities.toArray());
    }

    private String getEntityNames(Entity... entities){
        String names = "";
        for (Entity e:entities){
            names += e.getEntityData().getName() + ", ";
        }
        names += " ";
        names.replace(",  ", "");
        return names;
    }
}
