package model.team;

import java.awt.Color;

import model.unit.FireLord;
import model.unit.Henchman;
import model.unit.Marksman;

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