package model;

import java.util.ArrayList;

public class Villians extends Team
{
	ArrayList<Unit> units;
	
	public Villians(String name)
	{
		super(name);
		//name = "Heroes";
		units = new ArrayList<Unit>();
	//	units[0] = new Marksman();
	}
	
	public void setUnits(Unit u){
		units.add(u);
	}
	
	public ArrayList<Unit> getUnits()
	{
		return units;
	}



}