package mechanics.encounters;

import mechanics.entities.Entity;
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

        return (Entity.isAlive(targets));
    }

    private String getVictor(){
        return Entity.isAlive((Entity[])startingEntities.toArray()) ? getEntityNames((Entity[])startingEntities.toArray()) : getEntityNames((Entity[])approachingEntities.toArray());
    }

    private String getLoser(){
        return Entity.isAlive((Entity[])startingEntities.toArray()) ? getEntityNames((Entity[])approachingEntities.toArray()) : getEntityNames((Entity[])startingEntities.toArray());
    }

    private String getEntityNames(Entity... entities){
        String names = "";
        for (Entity e:entities){
            names += e.getName() + ", ";
        }
        names += " ";
        names.replace(",  ", "");
        return names;
    }
}
