package items;
import formatting.StringFormatting;
import items.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public List<Item> items;
    public List<Weapon> weapons;

    int totalItems = 0;

    public Inventory(){

    }
    public Inventory(Item item){
        this();
        addItem(item);
    }
    public Inventory(Weapon weapon){
        this();
        addWeapon(weapon);
    }

    public void addWeapon(Weapon weapon){
        if(weapons == null){
            weapons = new ArrayList<>();
        }
        this.weapons.add(weapon);
    }

    public void addItem(Item item){
        if(item instanceof Weapon) {
            addWeapon((Weapon) item);
        }
        else{
            if(items == null) items = new ArrayList<>();
            items.add(item);
        }
    }

    public void removeItem(Item item){
        if(item instanceof Weapon){
            removeWeapon((Weapon)item);
        }
        else if (items.contains(item)){
            items.remove(item);
        }
    }

    public void removeWeapon(Weapon weapon){
        if(weapons.contains(weapon)) weapons.remove(weapon);
    }

    @Override
    public String toString() {

            String inv = "";
            // Iterate through every item in the inventory and display them
            if (items != null &&items.size() > 0) {
                List<String> inventoryItemsStringLeftSide = new ArrayList<>();
                List<String> inventoryItemsStringRightSide = new ArrayList<>();
                inventoryItemsStringLeftSide.add("ITEMS");
                for (Item item : items) {
                    inventoryItemsStringLeftSide.add(item.getName());
                    inventoryItemsStringRightSide.add(item.toString());
                }
                inv += StringFormatting.formatAttributes(inventoryItemsStringLeftSide.toArray(new String[inventoryItemsStringLeftSide.size()]), inventoryItemsStringRightSide.toArray(new String[inventoryItemsStringRightSide.size()]), 0);
            }

            if(weapons != null && weapons.size() > 0){
                List<String> inventoryWeaponsStringLeftSide = new ArrayList<>();
                List<String> inventoryWeaponsStringRightSide = new ArrayList<>();
                inventoryWeaponsStringLeftSide.add("WEAPONS");
                for(Weapon weapon:weapons) {
                    inventoryWeaponsStringLeftSide.add(weapon.getName());
                    inventoryWeaponsStringRightSide.add(weapon.toString());
                }
                inv += StringFormatting.formatAttributes(inventoryWeaponsStringLeftSide.toArray(new String[inventoryWeaponsStringLeftSide.size()]), inventoryWeaponsStringRightSide.toArray(new String[inventoryWeaponsStringRightSide.size()]),0);
            }


        return inv;
    }
}
