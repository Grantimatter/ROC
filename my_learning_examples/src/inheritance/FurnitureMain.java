package inheritance;

public class FurnitureMain {
	public static void main(String[] args) {
		Table table = new Table(6, 250.00f, "Kitchen Table", 78, 46, "Cherry");
		table.DescribeFurniture();
		
		Recliner recliner = new Recliner(3, 400.00f, "Living Room Couch", "Leather");
		recliner.DescribeFurniture();
		
		CoffeeTable coffeeTable = new CoffeeTable(0,80.00f,"Living Room Coffee Table", 46, 24, "Glossy", 28, "White");
		coffeeTable.DescribeFurniture();
		
		Table desk = new Table(1, 300.00f, "Work Desk", 36, 18, "Mahogony");
		desk.DescribeFurniture();
		
		System.out.println("\n\nCasting Table");
		Table inheritCoffee = new CoffeeTable(4, 50.00f, "Booth", 64, 28, "Plastic", 24f, "red"); // Implicit Casting
		inheritCoffee.getLengthInches();
		
		CoffeeTable inheritTable = (CoffeeTable)inheritCoffee; // Explicit Casting
		System.out.println("Color: "+inheritTable.getColor());
	}
}
