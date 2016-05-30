package model.unit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.entity.Entity;
import model.manager.ValidDirection;
import model.team.Team;
import model.weapon.SwordDecorator;
import model.weapon.WeaponDecorator;

public abstract class Unit extends Entity
{
	protected String name;
	protected int health;
	protected boolean meleeAttack;
	protected int startingX;
	protected int startingY;
	protected boolean specialAttackUsed;
	protected int movementRadius;
	protected int movementDirection;
	protected boolean isHero;
	@JsonIgnore
	protected Team team;
	protected ValidDirection validMovement = new ValidDirection();
	protected WeaponDecorator weaponManager = new SwordDecorator(null);
	
	public abstract void specialAttack(Unit target);
	
	public Team getTeam()
	{
		return team;
	}
	
	public void setTeam(Team team)
	{
		this.team = team;
	}
	
	public int getMovementDirection()
	{
		return movementDirection;
	}
	
	public boolean getIsHero()
	{
		return isHero;
	}
	
	public boolean getSpecialAttackUsed()
	{
		return specialAttackUsed;
	}
	
	public void setSpecialAttackUsed(boolean specialAttackUsed)
	{
		this.specialAttackUsed = specialAttackUsed;
	}

	public int getMovementRadius()
	{
		return movementRadius;
	}
	
	public int getAttackRadius()
	{
		return weaponManager.getAttackRange();
	}
	
	public void reduceMovementRaidus(int amount)
	{
		if (movementRadius - amount >= 1)
			movementRadius -= amount;
		else
			movementRadius = 1;
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
	
	public void reduceHealth(int health)
	{
		this.health -= health;
	}
	
	public int getDamage()
	{
		return weaponManager.getDamage();
	}
	
	public int getAttackDirection()
	{
		return weaponManager.getAttackDirection();
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
