package data;

public class PlayerData extends EntityData{

    private int gold = 10;

    public PlayerData(String name){
        super(name);
    }
    public PlayerData(String name, int gold) {
        super(name);
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
