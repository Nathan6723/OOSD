package model;

import java.awt.Color;

public class Villians extends Team
{
	public Villians()
	{
		name = "Villians";
		colour = Color.RED;
		units.add(new FireLord());
		units.add(new Marksman());
		units.add(new Henchman());
	}
}