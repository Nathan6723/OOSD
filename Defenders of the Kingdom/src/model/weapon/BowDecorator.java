package model.weapon;

import model.manager.ValidDirection;

public class BowDecorator extends WeaponDecorator
{
	public BowDecorator(WeaponDecorator weaponDecorator)
	{
		super(weaponDecorator);
		range = 8;
		damage = 3;
		name = "Bow";
		weaponWeight = 2;
		attackDirection = ValidDirection.DIRECTION_VERTICAL
				+ ValidDirection.DIRECTION_DIAGONAL;
	}
}
