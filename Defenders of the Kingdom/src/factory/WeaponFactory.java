package factory;

import model.weapon.WeaponDecorator;

public class WeaponFactory
{
	private WeaponDecorator weaponDecorator;
	
	private final static int MAX_UNIT_WEIGHT = 2;
	
	public <T> void addWeapon(Class<T> weapon)
	{
		try
		{
			WeaponDecorator newWeaponDecorator = (WeaponDecorator) weapon.getDeclaredConstructor(
					WeaponDecorator.class).newInstance(weaponDecorator);
			if (newWeaponDecorator.getWeaponWeight() > MAX_UNIT_WEIGHT)
				return;
			weaponDecorator = newWeaponDecorator;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean hasCreated()
	{
		if (weaponDecorator == null)
			return false;
		else if (weaponDecorator.getWeaponWeight() < MAX_UNIT_WEIGHT)
			return false;
		return true;
	}
	
	public WeaponDecorator getWeapon()
	{
		WeaponDecorator newWeapon = weaponDecorator;
		weaponDecorator = null;
		return newWeapon;
	}
}
