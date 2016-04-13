package model;

public class Villians extends Team
{
	public Villians()
	{
		name = "Villians";
		units.add(new FireLord());
		units.add(new Marksman());
		units.add(new Henchman());
	}
}