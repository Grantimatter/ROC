package mechanics.encounters;

import com.sun.prism.ReadbackRenderTarget;
import mechanics.commands.ReadInput;
import mechanics.entities.Entity;
import mechanics.entities.enemies.Enemy;

public abstract class Encounter {

    protected Entity starterEntity;
    protected Entity targetEntity;

    public Encounter(){}

    public Encounter(Entity starterEntity, Entity targetEntity){
        this.starterEntity = starterEntity;
        this.targetEntity = targetEntity;
    }

    public void startEncounter(){
        starterEntity.setTargetEntity(targetEntity);
        startMessage(targetEntity);
        encounterLoop(starterEntity, targetEntity);
    }

    protected void encounterLoop(Entity starterEntity, Entity targetEntity){
        do{
            ReadInput.read(starterEntity);
        }while (inProgress());

        endEncounter();
    }

    protected void startMessage(Entity targetEntity) {
        String name = targetEntity.getName();
        String equippedWeaponString = targetEntity.getEquippedWeapon().getName().toLowerCase();
        String announcementString = "\nA " + name + " has approached";
        if (targetEntity.getEquippedWeapon() != null) {
            announcementString += ", equipped with a ";
            char c = equippedWeaponString.charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                announcementString = new StringBuilder(announcementString).insert(25, 'n').toString();
            }
            announcementString += equippedWeaponString + " w";
        } else {
            announcementString += ". W";
        }
        announcementString += "hat do you do?\n";
        System.out.print(announcementString);

    }

    protected void endEncounter(){

    }

    protected boolean inProgress(){
        return true;
    }
}
