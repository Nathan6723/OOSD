package model;

public class Villians extends Team
{
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
	Unit[] units;
	
	public Villians()
	{
		name = "Villians";
		units = new Unit[3];
		units[0] = new Henchman();
	}
}
