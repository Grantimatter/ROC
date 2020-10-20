package eg3;

public class Player {
	private int id;
	private String name;
	public Team team;

	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public void printPlayer() {
		System.out.println("ID : " + id);
		System.out.println("Name : " + name);
		
		if(team == null)
			System.out.println("Player is not in a team");
		else
			System.out.println("Team : " + team.getTeamName());
	}
	
}
