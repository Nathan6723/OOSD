package model.unit;

import model.manager.ValidDirection;

public class FireLord extends Unit
{
	int basehealth;
	
	public FireLord()
	{
		name ="FireLord";
		movementRadius = 5;
		health = 12;
		startingX = 4;
		startingY = 2;
		icon = 'F';
		isHero = true;
		movementDirection = ValidDirection.DIRECTION_HORIZONTAL
				+ ValidDirection.DIRECTION_VERTICAL
				+ ValidDirection.DIRECTION_DIAGONAL;
	}

	@Override
	public void specialAttack(Unit target)
	{
		target.reduceHealth(weaponManager.getDamage());
		health += weaponManager.getDamage();
	}
}
