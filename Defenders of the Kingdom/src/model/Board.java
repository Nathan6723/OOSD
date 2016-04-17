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
				cells[unit.getStartingX()-1][unit.getStartingY()-1].setEntity(unit);
			}
		}
		setChanged();
		notifyObservers();
	}
	
	
	// precondition checks distance is within the radius
		public boolean checkDistance(Cell initialpos, Cell finalpos)
		{
			if (initialpos.getX() == finalpos.getX() && initialpos.getY() == finalpos.getY())
				return false;
			Entity entity1 = initialpos.getEntity();
			if (entity1 == null || !(entity1 instanceof Unit))
				return false;
			Entity entity2 = finalpos.getEntity();
			if (entity2 != null)
				return false;
			Unit unit = (Unit)entity1;
			int distance = Math.abs(finalpos.getY() - initialpos.getY())
					+ Math.abs(finalpos.getX() - initialpos.getX());
			if (unit.getMovementRadius() >= distance)
			{
			
				return true;
			}
			else
				return false;
		}
		
	public boolean checkBounds(int x,int y){
			
			if((x<xSize)&&(y<ySize))
			return true;
			else 
				return false;
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