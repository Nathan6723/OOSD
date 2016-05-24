package model.weapon;

import model.WeaponManager;

public class SwordDecorator extends WeaponManager
{
	public SwordDecorator(WeaponManager weaponManager)
	{
		damage = 6;
		range = 2;
		this.weaponManager = weaponManager;
	}
	
	@Override
	public int getAttackRadius()
	{
		return weaponManager.getAttackRadius() + range;
	}
	
	@Override
	public int getDamage()
	{
		return weaponManager.getDamage() + damage;
	}
	
	@Override
	public int getNumWeapons()
	{
		return weaponManager.getNumWeapons() + 1;
	}
}
