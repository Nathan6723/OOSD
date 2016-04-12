package model;

import java.util.ArrayList;
import java.util.HashMap;

public  class Team
{
	private String name;
	private ArrayList<Unit> units;
	private HashMap<String,ArrayList<Unit>> mapteam;
	
	public Team(String name){
		mapteam=new HashMap<String,ArrayList<Unit>>();
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

public void setUnit(Unit u){
	units.add(u);
	mapteam.put(this.name,units);
}
	
public ArrayList<Unit> getUnits(){
  return  mapteam.get(this.name);


}

}
