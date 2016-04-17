package model;

import java.util.ArrayList;

public class Soldier extends Unit
{
	@SuppressWarnings("unused")
	private boolean attackflag;
	
	public Soldier()
	{
		name = "Soldier";
		attackRadius = 1;
		movementRadius = 2;
		health = 7;
		damage = 3;
		startingX = 3;
		startingY = 8;
		icon = 'S';
		attackflag = false;
	}
	
	public boolean isMoveValid(Cell initialCell, Cell finalCell)
	{
		return validMovement.isValidHorizontal(initialCell, finalCell, movementRadius)
				|| validMovement.isValidVertical(initialCell, finalCell, movementRadius);
	}
	
	//special power
	public void attackAll(ArrayList<Unit> unit){
		
		for(Unit u:unit)
			u.setDamage(2);
		this.attackflag=true;
		
	}
	
}
