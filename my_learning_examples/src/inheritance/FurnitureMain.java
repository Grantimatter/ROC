package inheritance;

public class FurnitureMain {
	public static void main(String[] args) {
		Table table = new Table(6, 250.00, "Kitchen Table", 78, 46, "Cherry");
		table.DescribeFurniture();
		
		Recliner recliner = new Recliner(3, 400.00, "Living Room Couch", "Leather");
		recliner.DescribeFurniture();
		
		CoffeeTable coffeeTable = new CoffeeTable(0,80.00,"Living Room Coffee Table", 46, 24, "Glossy", 28, "White");
		coffeeTable.DescribeFurniture();
	}
}
