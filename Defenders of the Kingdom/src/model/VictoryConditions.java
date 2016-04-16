package model;

import java.util.ArrayList;

public class VictoryConditions
{
	private static final String victoryMessage = " has won the game!";

	public boolean checkVictory(ArrayList<Unit> units)
	{
		for(Unit u:units ){
			if(u.getHealth()<=0)
				return true;
		}
		
		return false;
	}
	
	public void hideVictoryMessage()
	{
		
	}
}
