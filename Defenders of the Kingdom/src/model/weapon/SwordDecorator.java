package model.weapon;

public class SwordDecorator extends WeaponDecorator
{
	public SwordDecorator(WeaponDecorator weaponDecorator)
	{
		damage = 6;
		range = 2;
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
