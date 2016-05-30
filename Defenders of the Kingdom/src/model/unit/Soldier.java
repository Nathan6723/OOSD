package model.unit;

import model.manager.ValidDirection;

public class Soldier extends Unit
{
	public Soldier()
	{
		name = "Soldier";
		movementRadius = 2;
		health = 7;
		startingX = 3;
		startingY = 8;
		icon = 'S';
		movementDirection = ValidDirection.DIRECTION_HORIZONTAL
				+ ValidDirection.DIRECTION_VERTICAL;
	}
	
	@Override
	public void specialAttack(Unit target)
	{
		target.reduceHealth(weaponManager.getDamage() * 2);
	}
}
