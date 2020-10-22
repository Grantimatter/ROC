package inheritance;

public class Table extends Furniture {
	
	private float lengthInches;
	private float widthInches;
	private String finish;

	// Chained constructor to add extra attributes that only tables have.
	public Table(int seatCount, double price, String name, float lengthInches, float widthInches, String finish) {
		super(seatCount, price, name);
		this.lengthInches = lengthInches;
		this.widthInches = widthInches;
		this.finish = finish;
	}
	
	// Print the extra properties that tables have over abstract furniture
	@Override
	public void DescribeFurniture() {
		super.DescribeFurniture();
		System.out.println("Finish: "+finish);
		System.out.println("Size: "+(int)lengthInches+"\" x "+(int)widthInches+"\"");
	}

	// Getters and Setters
	public float getLengthInches() {
		return lengthInches;
	}

	public void setLengthInches(float lengthInches) {
		this.lengthInches = lengthInches;
	}

	public float getWidthInches() {
		return widthInches;
	}

	public void setWidthInches(float widthInches) {
		this.widthInches = widthInches;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

}
