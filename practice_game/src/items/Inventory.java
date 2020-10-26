package items;
import items.weapons.Weapon;
import java.util.List;

public class Inventory {

    public List<Item> items;
    public List<Weapon> weapons;

    public Inventory(){

    }
    public Inventory(Item item){
        addItem(item);
    }
    public Inventory(Weapon weapon){
        addWeapon(weapon);
    }

    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }

    public void addItem(Item item){
        if(item instanceof Weapon){
            addWeapon((Weapon)item);
        }
    }
}
