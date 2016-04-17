package model;

import java.awt.Color;

public class Villains extends Team
{
	public Villains()
	{
		name = "Villains";
		colour = Color.RED;
		units.add(new FireLord());
		units.add(new Marksman());
		units.add(new Henchman());
	}
}