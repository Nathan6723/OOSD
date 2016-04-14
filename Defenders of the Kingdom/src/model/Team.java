package model;

import java.util.ArrayList;

public class Team
{
	protected String name;
	protected ArrayList<Unit> units = new ArrayList<>();
	
	public int getNumUnits()
	{
		return units.size();
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Unit> getUnits()
	{
		return units;
	}
}
