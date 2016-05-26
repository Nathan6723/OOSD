package model.board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import model.player.Player;
import model.team.Team;
import model.unit.Unit;

public class Board extends Observable
{
	private Cell[][] cells = null;
	private final static int xSize = 10;
	private final static int ySize = 10;
	
	public Board()
	{
		cells = new Cell[xSize][ySize];
		for (int i = 0; i < xSize; ++i)
			for (int j = 0; j < ySize; ++j)
				cells[i][j] = new Cell(i, j);
	}
	
	public Board copyBoard()
	{
		Board board = new Board();
		board.setAllCells(cells.clone());
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
		setChanged();
		notifyObservers();
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