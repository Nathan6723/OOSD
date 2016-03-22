package model;

public class Team
{
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	private String name;
	private Unit[] units;
	
	public Unit[] getUnits()
	{
		return units;
	}
}
