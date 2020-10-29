package messages;

import formatting.ScreenFormatter;
import mechanics.entities.Entity;

public class EntityMessages {

    public static void announceEnity(Entity entity){
        String name = entity.getEntityData().getName();
        String announcementString = "\nA " + name + " has approached";

        if (entity.getEntityData().getEquippedWeapon() != null) {
            String equippedWeaponString = entity.getEntityData().getEquippedWeapon().getName().toLowerCase();

            announcementString += ", equipped with a";
            char c = equippedWeaponString.charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                announcementString = new StringBuilder(announcementString).append("n").toString();
            }
            announcementString += " " + equippedWeaponString;
        }
        announcementString += ". What do you do?\n";
        //System.out.print(announcementString);
        ScreenFormatter.addString(announcementString);
    }

    public static void announceEntities(Entity[] entities){
        for (Entity e: entities){
            announceEnity(e);
        }
    }
}
