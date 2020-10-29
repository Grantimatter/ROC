package messages;

import formatting.ScreenFormatter;
import items.Inventory;

public class PlayerMessages {
    public static void inventoryMessage(Inventory inventory){
        //System.out.print(inventory.toString()+"\n");
        ScreenFormatter.addString(inventory.toString());
    }
}
