package model;

public class Player
{
	private String name;
	private Team team;
	private int unitCount;
	private int score;
	
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