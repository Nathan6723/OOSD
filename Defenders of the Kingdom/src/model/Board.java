package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class Board extends Observable
{
	private static Board instance = null;
	private Cell[][] cells = null;
	private final static int xSize = 10;
	private final static int ySize = 10;
	
	private Board()
	{
		cells = new Cell[xSize][ySize];
		for (int i = 0; i < xSize; ++i)
			for (int j = 0; j < ySize; ++j)
				cells[i][j] = new Cell(i, j);
	}
	
	public static Board getInstance()
	{
		if (instance == null)
			return new Board();
		return instance;
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
				cells[unit.getStartingX()][unit.getStartingY()].setEntity(unit);
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
}