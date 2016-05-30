package model.unit;

import model.manager.ValidDirection;

public class Henchman extends Unit
{
	public Henchman()
	{
		name= "Henchman";
		movementRadius = 2;
		health = 9;
		startingX = 2;
		startingY = 4;
		icon = 'H';
		movementDirection = ValidDirection.DIRECTION_DIAGONAL;
	}

	@Override
	public void specialAttack(Unit target)
	{
		target.reduceHealth(target.getHealth() / 2);
	}
}
