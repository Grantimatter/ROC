package eg3;

public class PlayerMain {

	public static void main(String[] args) {
		Player p1 = new Player(100, "Johnson");
		System.out.println("\nPrinting p1");
		p1.printPlayer();
		
		Team t = new Team(99999, "Rockets", "Ulysses");
		Player p2 = new Player(103, "Kirk");
		p2.setTeam(t);
		System.out.println("\nPrinting p2");
		p2.printPlayer();
	}
}
