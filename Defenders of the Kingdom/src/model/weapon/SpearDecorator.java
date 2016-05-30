package model.weapon;

import model.manager.ValidDirection;

public class SpearDecorator extends WeaponDecorator
{
	public SpearDecorator(WeaponDecorator weaponDecorator)
	{
		super(weaponDecorator);
		range = 3;
		damage = 4;
		name = "Spear";
		weaponWeight = 1;
		attackDirection = ValidDirection.DIRECTION_VERTICAL;
	}
}
