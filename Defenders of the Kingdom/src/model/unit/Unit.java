package model.unit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.board.Cell;
import model.entity.Entity;
import model.manager.ValidMovement;
import model.team.Team;
import model.weapon.WeaponDecorator;

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
	@JsonIgnore
	protected Team team;
	protected ValidMovement validMovement = new ValidMovement();
	protected WeaponDecorator weaponManager = new WeaponDecorator();
	
	public abstract boolean isMoveValid(Cell initialCell, Cell finalCell);
	
	public Team getTeam()
	{
		return team;
	}
	
	public void setTeam(Team team)
	{
		this.team = team;
	}

	public int getMovementRadius()
	{
		return movementRadius;
	}
	
	public int getAttackRadius()
	{
		return weaponManager.getAttackRadius();
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
		return weaponManager.getDamage();
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
