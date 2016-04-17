package model;

import controller.BoardController;

public class Movement
{
	private BoardController boardController;
	private boolean canMove = false;
	private Cell cell1;
	
	public Movement(BoardController boardController)
	{
		this.boardController = boardController;
	}
	
	public boolean getCanMove()
	{
		return canMove;
	}

	public boolean canMove(Cell cell, Player player)
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
		cell1 = cell;
		return canMove = true;
	}
	
	public boolean moveUnit(Cell cell2)
	{
		canMove = false;
		if (cell1.getX() == cell2.getX() && cell1.getY() == cell2.getY())
		{
			boardController.printMessage("Movement cancelled");
			return false;
		}
		Entity entity1 = cell1.getEntity();
		if (entity1 == null || !(entity1 instanceof Unit))
			return printError();
		Entity entity2 = cell2.getEntity();
		if (entity2 != null)
			return printError();
		Unit unit = (Unit)entity1;
		if (unit.isMoveValid(cell1, cell2))
		{
			cell2.setEntity(cell1.getEntity());
			cell1.setEntity(null);
			boardController.printMessage(unit.getName() + " moved from " + String.valueOf((char)(cell1.getX() + 64))
						+ "," + cell1.getY() + " to " + String.valueOf((char)(cell2.getX() + 64)) + "," + cell2.getY());
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
