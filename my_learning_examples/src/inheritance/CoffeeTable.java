package inheritance;

public class CoffeeTable extends Table {

	private float height;
	private String color;
	
	// Chained constructor to add properties to a coffee table
	public CoffeeTable(int seatCount, double price, String name, float lengthInches, float widthInches, String finish, float height, String color) {
		super(seatCount, price, name, lengthInches, widthInches, finish);
		this.height = height;
		this.color = color;
	}
	
	// Describe properties of a coffee table
	public void DescribeFurniture() {
		super.DescribeFurniture();
		System.out.println("Height: "+(int)height+"\"");
		System.out.println("Color: "+color);
	}

	// Getters and Setters
	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
