package model.manager;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.annotation.JsonIgnore;

import controller.BoardController;
import model.board.Board;
import model.board.Cell;
import model.entity.Entity;
import model.unit.Unit;

public class Attack
{
	@JsonIgnore
	private Board board;
	@JsonIgnore
	private BoardController boardController;
	private ValidDirection validDirection = new ValidDirection();
	
	private Unit attackingUnit;
	private boolean isAttacking = false;
	private HashSet<Cell> potentialTargetCells;

	private final static String ATTACK_MESSAGE = "Choose a unit to attack...";
	private final static String NO_TARGETS_MESSAGE = "No targets are in range to attack\n"
			+ "Turn is now ending";
	private final static String INVALID_TARGET_MESSAGE = "Invalid target selected";
	private final static String DAMAGE_MESSAGE[] = new String[] {" was hit by ", " for ", " damage!"};
	private final static String HEALTH_MESSAGE[] = new String[] {" now has ", " health left"};
	private final static String SPECIAL_ATTACK_TITLE = "Special Attack";
	private final static String SPECIAL_ATTACK_MESSAGE[] = new String[] {"Would you like to use ", "'s special attack?"};
	private final static String KILLED_MESSAGE = " has been killed!";
	
	public Attack(BoardController boardController)
	{
		this.boardController = boardController;
	}
	
	public boolean captureAttack(Cell cell)
	{
		if (!isAttacking)
			return findTargets(cell);
		else
			return attackUnit(cell);
	}
	
	public boolean findTargets(Cell attackingUnitCell)
	{
		attackingUnit = (Unit)attackingUnitCell.getEntity();
		potentialTargetCells = new HashSet<>();
		
		for (int i = 0; i < board.getX(); ++i)
		{
			for (int j = 0; j < board.getY(); ++j)
			{
				Cell targetCell = board.getCell(i, j);
				if (!validDirection.isValidDirection(attackingUnit.getAttackDirection(), 
						attackingUnitCell, targetCell,
						attackingUnit.getAttackRadius()))
					continue;
				targetCell.setPotentialCell(false);
				Unit targetUnit = getUnitFromCell(targetCell);
				if (targetUnit == null)
					continue;
				targetCell.setPotentialCell(true);
				potentialTargetCells.add(targetCell);
			}
		}
		
		if (potentialTargetCells.size() == 0)
		{
			boardController.printMessage(NO_TARGETS_MESSAGE);
			return false;
		}
		
		boardController.printMessage(ATTACK_MESSAGE);
		isAttacking = true;
		return true;
	}
	
	public boolean attackUnit(Cell targetUnitCell)
	{
		if (!targetUnitCell.isPotentialCell())
		{
			boardController.printMessage(INVALID_TARGET_MESSAGE);
			return false;
		}
		
		int specialAttack = JOptionPane.NO_OPTION;
		
		if (!attackingUnit.getSpecialAttackUsed())
		{
			specialAttack = boardController.getConfirm(SPECIAL_ATTACK_MESSAGE[0]
					+ attackingUnit.getName() + SPECIAL_ATTACK_MESSAGE[1],
					SPECIAL_ATTACK_TITLE);
		}
		
		Unit targetUnit = getUnitFromCell(targetUnitCell);
		int originalHealth = targetUnit.getHealth();
		
		if (specialAttack == JOptionPane.NO_OPTION)
		{
			int damage = attackingUnit.getDamage();
			targetUnit.reduceHealth(damage);
		}
		else
		{
			attackingUnit.specialAttack(targetUnit);
			attackingUnit.setSpecialAttackUsed(true);
		}
		
		int healthDiff = originalHealth - targetUnit.getHealth();
		
		boardController.printMessage(targetUnit.getName() + DAMAGE_MESSAGE[0]
				+ attackingUnit.getName() + DAMAGE_MESSAGE[1]
						+ healthDiff + DAMAGE_MESSAGE[2]);

		if (targetUnit.getHealth() <= 0)
		{
			targetUnitCell.setEntity(null);
			boardController.printMessage(targetUnit.getName() + KILLED_MESSAGE);
		}
		else
		{
			boardController.printMessage(targetUnit.getName() + HEALTH_MESSAGE[0]
					+ targetUnit.getHealth() + HEALTH_MESSAGE[1]);
		}
		
		Iterator<Cell> iter = potentialTargetCells.iterator();
		
		while (iter.hasNext())
			iter.next().setPotentialCell(false);
		
		isAttacking = false;
		return true;
	}
	
	private Unit getUnitFromCell(Cell cell)
	{
		Entity entity = cell.getEntity();
		if (cell.getEntity() == null)
			return null;
		if (!(entity instanceof Unit))
			return null;
		Unit unit = (Unit)entity;
		if (unit.getTeam() == attackingUnit.getTeam())
			return null;
		return unit;
	}
	
	public boolean getIsAttacking()
	{
		return isAttacking;
	}
	
	public void setIsAttacking(boolean isAttacking)
	{
		this.isAttacking = isAttacking;
	}
	
	public void setBoard(Board board)
	{
		this.board = board;
	}
}
