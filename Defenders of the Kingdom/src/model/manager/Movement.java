package model.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import controller.BoardController;
import model.board.Cell;
import model.entity.Entity;
import model.player.Player;
import model.unit.Unit;

public class Movement
{
	@JsonIgnore
	private BoardController boardController;
	private boolean canMove = false;
	private Cell initialCell;
	private ValidDirection validDirection = new ValidDirection();

	public Movement() {}
	
	public Movement(BoardController boardController)
	{
		this.boardController = boardController;
	}
	
	public void setBoardController(BoardController boardController)
	{
		this.boardController = boardController;
	}
	
	public Cell getInitialCell()
	{
		return initialCell;
	}
	
	public void setInitialCell(Cell initialCell)
	{
		this.initialCell = initialCell;
	}
	
	public boolean getCanMove()
	{
		return canMove;
	}
	
	public void setCanMove(boolean canMove)
	{
		this.canMove = canMove;
	}

	@Ensures("initialCell")
	public boolean isCellValid(Cell cell, Player player)
	{
		Entity entity = cell.getEntity();
		if (entity == null || !(entity instanceof Unit))
			return false;
		Unit unit = (Unit)entity;
		if (!player.getTeam().getName().equals(unit.getTeam().getName()))
		{
			boardController.printMessage(unit.getName() + " is not part of your team");
			return false;
		}
		boardController.printMessage("Choose where to move " + unit.getName());
		initialCell = cell;
		return canMove = true;
	}
	
	@Requires("isCellValid(Cell cell, Player player)")
	public boolean isSelfClick(Cell finalCell)
	{
		if (initialCell.getX() == finalCell.getX() && initialCell.getY() == finalCell.getY())
		{
			boardController.printMessage("Movement cancelled");
			return true;
		}
		return false;
	}
	
	@Requires("isSelfClicked()")
	public boolean moveUnit(Cell finalCell)
	{
		Entity entity1 = initialCell.getEntity();
		if (entity1 == null || !(entity1 instanceof Unit))
			return printError();
		Entity entity2 = finalCell.getEntity();
		if (entity2 != null)
			return printError();
		Unit unit = (Unit)entity1;
		if (validDirection.isValidDirection(unit.getMovementDirection(), initialCell, finalCell, unit.getMovementRadius()))
		{
			finalCell.setEntity(initialCell.getEntity());
			initialCell.setEntity(null);
			boardController.printMessage(unit.getName() + " moved from " + String.valueOf((char)(initialCell.getX() + 64))
						+ "," + initialCell.getY() + " to " + String.valueOf((char)(finalCell.getX() + 64)) + "," + finalCell.getY());
			return true;
		}
		else
			return printError();
	}
	
	private boolean printError()
	{
		boardController.printMessage("Invalid move");
		return false;
	}
}
