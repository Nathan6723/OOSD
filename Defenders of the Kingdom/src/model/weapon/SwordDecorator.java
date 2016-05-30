package model.weapon;

import model.manager.ValidDirection;

public class SwordDecorator extends WeaponDecorator
{
	public SwordDecorator(WeaponDecorator weaponDecorator)
	{
		super(weaponDecorator);
		range = 2;
		damage = 6;
		name = "Sword";
		weaponWeight = 1;
		attackDirection = ValidDirection.DIRECTION_HORIZONTAL;
	}
}
