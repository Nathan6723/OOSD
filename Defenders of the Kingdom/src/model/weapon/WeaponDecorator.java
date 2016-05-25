package model.weapon;

public class WeaponDecorator
{
	protected int damage;
	protected int range;
	protected WeaponDecorator weaponDecorator;
	
	public int getAttackRadius()
	{
		return 0;
	}
	public int getDamage()
	{
		return 0;
	}
	
	public int getNumWeapons()
	{
		return 0;
	}
	
	public WeaponDecorator removeWeapon()
	{
		return this;
	}
}