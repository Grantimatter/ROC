package mechanics.encounters;

import general.RandomCollection;
import mechanics.entities.Entity;
import mechanics.entities.enemies.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EncounterGenerator {

    public static Encounter generateHostileEncounter(Entity starterEntity){
        RandomCollection<Enemy> randomEnemy = new RandomCollection<Enemy>()
                .add(10, new Warlock())
                .add(15, new Thief())
                .add(10, new Barbarian());

        return new HostileEncounter(new Entity[] {starterEntity}, randomEnemy.next());
    }

    public static Encounter generatePeacefulEncounter(Entity starterEntity){
        System.out.println("Peaceful Encounter! (Not finished)\n");
        return null;
        //throw new NotImplementedException();
    }

    public static Encounter generateRandomEncounter(Entity starterEntity){
        // Create weighted types of encounters that can occur
        RandomCollection<String> randomWeightedInteger = new RandomCollection<String>().add(1, "peaceful").add(3,"none").add(3,"hostile");
        switch(randomWeightedInteger.next()){
            case "peaceful":
                return generatePeacefulEncounter(starterEntity);
            case "none":
                return null;
            case "hostile":
                return generateHostileEncounter(starterEntity);
            default: return null;
        }
    }
}
