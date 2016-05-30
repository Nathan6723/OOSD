package model.unit;

import model.manager.ValidDirection;

public class Marksman extends Unit
{
	public Marksman()
	{	
		name= "Marksman";
		movementRadius = 2;
		health = 7;
		startingX = 7;
		startingY = 1;
		icon = 'M';
		movementDirection = ValidDirection.DIRECTION_VERTICAL
				+ ValidDirection.DIRECTION_DIAGONAL;
	}
	
	@Override
	public void specialAttack(Unit target)
	{
		target.reduceHealth(weaponManager.getDamage());
		target.reduceMovementRaidus(1);
	}
}
