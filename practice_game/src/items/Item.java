package items;

import com.sun.javafx.binding.StringFormatter;
import formatting.StringFormatting;

public abstract class Item {
    protected String name;
    protected int value;
    protected int durability;
    protected boolean hasDurability;

    public Item(){
        this("default_item",0, 0);
    }
    public Item(String name, int value, int durability)
    {
        this.name = name;
        this.value = value;
        this.durability = durability;
        hasDurability = durability > 0;
    }

    protected void setValue(int value){
        this.value = value;
    }
    protected void setName(){
        this.name = name;
    }

    protected int getValue(){
        return value;
    }
    protected String getName(){
        return name;
    }

    @Override
    public String toString() {
        String[] valueNames = new String[]{"Value","Durability"};
        String[] values = new String[]{Integer.toString(value),Integer.toString(durability)};

        String s = name + StringFormatting.formatAttributes(valueNames,values,0);
        if(!hasDurability){
            // Remove durability if the item does not have a durability;
            s.replaceAll("(?m)^[Durability].*", "");
        }
        return s;
    }
}
