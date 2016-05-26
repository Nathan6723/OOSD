package model.weapon;

import model.manager.ValidMovement;

public class SwordDecorator extends WeaponDecorator
{
	public SwordDecorator(WeaponDecorator weaponDecorator)
	{
		range = 2;
		damage = 6;
		attackDirection = ValidMovement.DIRECTION_VERTICAL;
		name = "Sword";
		this.weaponDecorator = weaponDecorator;
	}
	
	@Override
	public int getAttackRadius()
	{
		return weaponDecorator.getAttackRadius() + range;
	}
	
	@Override
	public int getDamage()
	{
		return weaponDecorator.getDamage() + damage;
	}
	
	@Override
	public int getNumWeapons()
	{
		return weaponDecorator.getNumWeapons() + 1;
	}
	
	@Override
	public WeaponDecorator removeWeapon()
	{
		return weaponDecorator;
	}
}
