package model.team;

import java.awt.Color;

import model.unit.Avatar;
import model.unit.Scout;
import model.unit.Soldier;

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