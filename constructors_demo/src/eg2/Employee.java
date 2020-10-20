package eg2;

public class Employee {
	private int id;
	private String name;
	private long contact;
	private String city;
	private String email;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, long contact) {
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	
	public Employee(int id, String name, long contact, String city, String email) {
		this(id,name,contact); // Constructor chaining
		this.city = city;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void printEmployee() {
		System.out.println("ID : " + id);
		System.out.println("Name : " + name);
		System.out.println("Contact : " + contact);
		System.out.println("City : " + city);
		System.out.println("Email : " + email);
	}
}
