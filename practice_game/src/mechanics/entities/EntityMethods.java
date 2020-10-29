package mechanics.entities;

public class EntityMethods {

    public static boolean areAlive(Entity[] entities){
        boolean alive = false;
        for(Entity e:entities){
            if(e.isAlive()){
                alive = true;
                break;
            }
        }
        return alive;
    }
}
