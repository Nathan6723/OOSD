package model.weapon;

public class WeaponDecorator
{
	protected int attackDirection;
	protected int damage;
	protected int range;
	protected String name;
	protected int weaponWeight;
	protected WeaponDecorator weaponDecorator;
	
	public WeaponDecorator() {}
	
	public WeaponDecorator(WeaponDecorator weaponDecorator)
	{
		this.weaponDecorator = weaponDecorator;
	}
	
	public int getAttackRange()
	{
		int totalDamage = range;
		if (weaponDecorator != null)
			totalDamage = Math.max(range, weaponDecorator.getDamage());
		return totalDamage;
	}
	
	public int getAttackDirection()
	{
		int directions = attackDirection;
		if (weaponDecorator != null)
			directions += weaponDecorator.getAttackDirection();
		return directions;
	}
	
	public int getDamage()
	{
		int totalDamage = damage;
		if (weaponDecorator != null)
			totalDamage += weaponDecorator.getDamage();
		return totalDamage;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getWeaponWeight()
	{
		int totalWeight = weaponWeight;
		if (weaponDecorator != null)
			totalWeight += weaponDecorator.getWeaponWeight();
		return totalWeight;
	}
	
	public int getNumWeapons()
	{
		int numWeapons = 1;
		if (weaponDecorator != null)
			numWeapons += weaponDecorator.getNumWeapons();
		return numWeapons;
	}
	
	public WeaponDecorator removeWeapon(Class<WeaponDecorator> weaponClass)
	{
		if (getClass() == weaponClass)
			return weaponDecorator;
		else
			return weaponDecorator = weaponDecorator.removeWeapon(weaponClass);
	}
}
