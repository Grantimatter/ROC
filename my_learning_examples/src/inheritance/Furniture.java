package inheritance;

public abstract class Furniture {
	protected int seatCount;
	protected double price;
	protected String name;
	
	// New furniture constructor
	public Furniture(int seatCount, double price, String name) {
		this.seatCount = seatCount;
		this.price = price;
		this.name = name;
	}
	
	// Print all values from furniture.
	public void DescribeFurniture() {
		System.out.println("\nName: "+name);
		System.out.println("Price: $"+(int)price);
		System.out.println("Seats: "+seatCount);
	}
	
	
	// Getters and Setters
	public int getSeatPrice() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
