package model;

public class Player
{
	private String name;
	private Team team;
	private int unitCount;
	private int score;
	private Heroes heroes;
	private Villians villians;
	public Player()
	{
		
	}
	
	public Player(String name, Team team)
	{
		this.name = name;
		this.team = team;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public int getUnitCount() {
		return unitCount;
	}

	public Heroes getHeroes() {
		return heroes;
	}

	public Villians getVillians() {
		return villians;
	}

	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}

	public void setHeroes(Heroes h) {
		this.heroes = h;
	}
	public void setVillians(Villians v) {
		this.villians =v;
	}

	public void decrementUnitCount()
	{
		unitCount -= 1;		
	}
	
	public void incrementScore()
	{
		score += 1;
	}
}