package model;

import java.util.Scanner;

public abstract class Unit extends Entity
{
	protected String name;
	protected int health;
	protected int damage;
	protected boolean meleeAttack;
	protected int startingX;
	protected int startingY;
	protected int attackRadius;
	protected boolean cannotUseSpecialPower;
	protected int movementRadius;
	protected String teamName;
	
	public boolean moveUnit(Cell cell1, Cell cell2)
	{
		if (cell1.getX() == cell2.getX() && cell1.getY() == cell2.getY())
			return false;
		Entity entity1 = cell1.getEntity();
		if (entity1 == null || !(entity1 instanceof Unit))
			return false;
		Entity entity2 = cell2.getEntity();
		if (entity2 != null)
			return false;
		Unit unit = (Unit)entity1;
		int distance = Math.abs(cell2.getY() - cell1.getY())
				+ Math.abs(cell2.getX() - cell1.getX());
		if (unit.getMovementRadius() >= distance)
		{
			cell2.setEntity(cell1.getEntity());
			cell1.setEntity(null);
			return true;
		}
		else
			return false;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public int getMovementRadius()
	{
		return movementRadius;
	}
	
	public int getAttackRadius()
	{
		return attackRadius;
	}
	
	public void setAttackRadius(int attackRadius)
	{
		this.attackRadius = attackRadius;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public boolean isMeleeAttack()
	{
		return meleeAttack;
	}

	public void setMeleeAttack(boolean meleeAttack)
	{
		this.meleeAttack = meleeAttack;
	}

	public void setStartingX(int startingX)
	{
		this.startingX = startingX;
	}

	public void setStartingY(int startingY)
	{
		this.startingY = startingY;
	}
	
	public int getStartingX()
	{
		return startingX;
	}
	
	public int getStartingY()
	{
		return startingY;
	}
}
