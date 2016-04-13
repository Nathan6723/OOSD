package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Board
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
				cells[unit.getStartingX()][unit.getStartingY()].setObject(unit);
			}
		}
	}
	
	public boolean moveUnit(int x1, int y1, int x2, int y2)
	{
		Cell cell2 = cells[x2][y2];
		Object obj = cell2.getObject();
		if (obj == null || !(obj instanceof Unit))
			return false;
		Cell cell1 = cells[x1][y1];
		cell2.setObject(cell1.getObject());
		cell1.setObject(null);
		return true;
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