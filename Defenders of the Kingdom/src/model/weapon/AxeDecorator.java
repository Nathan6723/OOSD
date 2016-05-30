package model.weapon;

import model.manager.ValidDirection;

public class AxeDecorator extends WeaponDecorator
{
	public AxeDecorator(WeaponDecorator weaponDecorator)
	{
		super(weaponDecorator);
		range = 1;
		damage = 8;
		name = "Axe";
		weaponWeight = 1;
		attackDirection = ValidDirection.DIRECTION_DIAGONAL;
	}
}
