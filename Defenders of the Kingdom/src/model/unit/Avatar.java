package model.unit;

import model.manager.ValidDirection;

public class Avatar extends Unit
{
	private int basehealth;
	
	public Avatar()
	{
		name = "Avatar";
		movementRadius = 5;
		health = basehealth = 10;
		startingX = 6;
		startingY = 9;
		icon = 'A';
		isHero = true;
		movementDirection = ValidDirection.DIRECTION_HORIZONTAL
				+ ValidDirection.DIRECTION_VERTICAL
				+ ValidDirection.DIRECTION_DIAGONAL;
	}
	
	@Override
	public void specialAttack(Unit target)
	{
		int healAmount = basehealth - health;
		health += healAmount;
		target.reduceHealth(healAmount);
	}
}
