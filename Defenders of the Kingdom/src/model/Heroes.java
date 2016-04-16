package model;

import java.awt.Color;

public class Heroes extends Team
{
	public Heroes()
	{
		name = "Heroes";
		colour = Color.BLUE;
		units.add(new Avatar());
		units.add(new Soldier());
		units.add(new Scout());
	}
}