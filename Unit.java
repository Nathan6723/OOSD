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
	


	public abstract boolean moveUnit(Cell initialpos,Cell finalpos,Board b); 
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
