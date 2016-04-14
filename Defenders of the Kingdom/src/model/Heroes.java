package model;

public class Heroes extends Team
{
	public Heroes()
	{
		name = "Heroes";
		units.add(new Avatar());
		units.add(new Soldier());
		units.add(new Scout());
	}
}