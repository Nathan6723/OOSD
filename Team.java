package model;

import java.awt.Color;
import java.util.ArrayList;

public class Team
{
	protected String name;
	protected Color colour;
	protected ArrayList<Unit> units = new ArrayList<>();
	
	public int getNumUnits()
	{
		return units.size();
	}
	
	public Color getColour()
	{
		return colour;
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
