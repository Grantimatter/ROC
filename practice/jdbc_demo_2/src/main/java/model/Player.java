package model;

public class Player {

    private int id;
    private int age;
    private String name;
    private String teamName;
    private long contact;
    private String gender;

    public Player(int id, int age, String name, String teamName, long contact, String gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.teamName = teamName;
        this.contact = contact;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
                ", contact=" + contact +
                ", gender='" + gender + '\'' +
                '}';
    }
}
