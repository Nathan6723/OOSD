package model;

public class Player
{
	private String name;
	private Team team;
	private int unitCount;
	private int score;
	
	public Player(){
		
	}
	
	
	public Player(String name){
		
	}
	public String getName()
	{
		return name;
	}
	
	public Player(String name,Team t){
		team=t;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public Team getTeam()
	{
		return team;
	}

	public void setTeam(Team team)
	{
		this.team = team;
	}
	
	public int getUnitCount()
	{
		return unitCount;
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