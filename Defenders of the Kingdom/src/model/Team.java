package model;

import java.util.ArrayList;

public  class Team
{
	private String name;
	private ArrayList<Unit> units;
	
	public Team(String name){
		units=new ArrayList<Unit>();
		this.name=name;
	}
	
	
	public  String getName()
	{
		return name;
	}

	public  void setName(String name)
	{
		
	}

/*public void setUnit(Unit u){
	units.add(u);
}*/
	
/*public ArrayList<Unit> getUnits(){;
return units;
}*/
}
