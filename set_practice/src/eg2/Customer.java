package eg2;

public class Customer {

    private int id;
    private String name;

    public Customer(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "\nCustomer [id= "+id+" Name= "+name+"]";
    }
}
