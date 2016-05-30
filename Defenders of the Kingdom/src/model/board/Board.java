package model.board;

import java.util.ArrayList;
import java.util.Iterator;

import model.entity.Entity;
import model.entity.Obstacle;
import model.player.Player;
import model.team.Team;
import model.unit.Unit;

public class Board
{
	private Cell[][] cells = new Cell[xSize][ySize];
	
	private final static int xSize = 10;
	private final static int ySize = 10;
	
	public Board()
	{
		for (int i = 0; i < xSize; ++i)
			for (int j = 0; j < ySize; ++j)
				cells[i][j] = new Cell(i, j);
	}
	
	public Board copyBoard()
	{
		Board board = new Board();
		Cell[][] newCells = new Cell[xSize][ySize];
		for (int i = 0; i < xSize; ++i)
		{
			for (int j = 0; j < ySize; ++j)
			{
				newCells[i][j] = new Cell(i, j);
				Cell newCell = newCells[i][j];
				Entity currentEntity = cells[i][j].getEntity();
				if (currentEntity instanceof Unit)
				{
					Unit currentUnit = (Unit)currentEntity;
					Unit newUnit = null;
					try
					{
						newUnit = currentUnit.getClass().newInstance();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					newUnit.setHealth(currentUnit.getHealth());
					newUnit.setTeam(currentUnit.getTeam());
					newUnit.setSpecialAttackUsed(currentUnit.getSpecialAttackUsed());
					newUnit.setWeaponDecorator(currentUnit.getWeaponDecorator());
					newCell.setEntity(newUnit);
				}
				else if (currentEntity instanceof Obstacle)
					newCell.setEntity(new Obstacle());
			}
		}
		board.setAllCells(newCells);
		return board;
	}
	
	public void placeUnits(Player[] players)
	{
		for (int i = 0; i < players.length; ++i)
		{
			Team team = players[i].getTeam();
			ArrayList<Unit> units = team.getUnits();
			Iterator<Unit> iter = units.iterator();
			while (iter.hasNext())
			{
				Unit unit = iter.next();
				cells[unit.getStartingX() - 1][unit.getStartingY() - 1].setEntity(unit);
			}
		}	
	}
	
	public int getX()
	{
		return xSize;
	}
	
	public int getY()
	{
		return ySize;
	}
	
	public Cell getCell(int x, int y)
	{
		return cells[x][y];
	}
	
	public Cell[][] getAllCells()
	{
		return cells;
	}
	
	public void setAllCells(Cell[][] cells)
	{
		this.cells = cells;
	}
}