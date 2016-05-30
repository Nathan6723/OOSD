package model.player;

import model.team.Team;

public class Player
{
	private String name;
	private Team team;
	private int unitCount;
	private int score;
	private int undoCount;
	private boolean hasUsedUndo;
	
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

	public int getUndoCount()
	{
		return undoCount;
	}

	public void incrementUndoCount()
	{
		this.undoCount += 1;
	}

	public boolean HasUsedUndo()
	{
		return hasUsedUndo;
	}

	public void setHasUsedUndo(boolean hasUsedUndo)
	{
		this.hasUsedUndo = hasUsedUndo;
	}
}