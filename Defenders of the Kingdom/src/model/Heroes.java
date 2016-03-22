package model;

public class Heroes extends Team
{
	String name;
	Unit[] units;
	
	public Heroes()
	{
		name = "Heroes";
		units = new Unit[3];
		units[0] = new Marksman();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}