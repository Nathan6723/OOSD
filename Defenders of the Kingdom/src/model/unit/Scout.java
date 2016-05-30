package model.unit;

import java.util.Random;

import model.manager.ValidDirection;

public class Scout extends Unit
{
	Random random = new Random();
	
	public Scout()
	{
		name = "Scout";
		movementRadius = 3;
		health = 5;
		startingX = 9;
		startingY = 7;
		icon = 'C';
		movementDirection = ValidDirection.DIRECTION_HORIZONTAL
				+ ValidDirection.DIRECTION_VERTICAL;
	}

	@Override
	public void specialAttack(Unit target)
	{
		target.reduceHealth(weaponManager.getDamage());
		target.setSpecialAttackUsed(true);
	}
}
