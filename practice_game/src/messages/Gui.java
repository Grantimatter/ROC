package messages;

import data.EntityData;
import data.PlayerData;
import formatting.StringFormatting;
import mechanics.entities.Entity;
import mechanics.entities.Player;

public class Gui {
    public static String getGuiString(Entity entity){
        if(entity == null || entity.getEntityData() == null) return null;

        EntityData data = entity.getEntityData();

        String ui = "";

        String[] valueNames = {"HEALTH","ENERGY"};
        String[] values = {Integer.toString(data.getHealth()), Integer.toString(data.getEnergy())};
        ui = StringFormatting.formatAttributesInline(data.getName(), valueNames, values, "|");

        return ui;
    }
}
