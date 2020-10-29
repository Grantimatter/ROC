package mechanics.encounters;

import mechanics.commands.ReadInput;
import mechanics.entities.Entity;
import messages.EntityMessages;
import messages.Gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Encounter {

    protected List<Entity> startingEntities;
    protected List<Entity> approachingEntities;
    protected abstract boolean inProgress();

    public Encounter(Entity[] startingEntities, Entity... approachingEntities){
        this.startingEntities = Arrays.asList(startingEntities);
        this.approachingEntities = Arrays.asList(approachingEntities);
    }

    public void startEncounter(){

        // Refine this and add a targeting feature (only targets the first entity)
        if(startingEntities.size() > 0 && approachingEntities.size() > 0) {
            for (int i = 0; i < startingEntities.size(); i++) {
                startingEntities.get(i).setTargetEntity(approachingEntities.get(0));
            }
            for (int i = 0; i < approachingEntities.size(); i++) {
                approachingEntities.get(i).setTargetEntity(startingEntities.get(0));
                //EnityMessages.(approachingEntities[i]);
            }

            EntityMessages.announceEntities((Entity[])approachingEntities.toArray());
            encounterLoop();
        }
    }

    protected void encounterLoop(){
        //allEntities = startingEntities + approachingEntities;
        //allEntities = ArrayUtils.addAll();
        List<Entity> allEntities = new ArrayList<>(startingEntities);
        allEntities.addAll(approachingEntities);
        do{
            for(Entity e:allEntities){
                if(e.isAlive()) {
                    while (true) {
                        try {
                            ReadInput.read(e, e.getEntityCommand());
                            break;
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            }
        } while (inProgress());
    }
}
