package model;

import java.util.ArrayList;
import java.util.Iterator;

import Interfaces.Object;
import Interfaces.Mobility;
public class Board implements Mobility
{
	private static Board instance = null;
	private Cell[][] cells = null;

	private Boardsize b;
	private Board()
	{ 
		b=new Boardsize();
		cells = new Cell[b.getxSize()][b.getySize()];
		for (int i = 0; i < b.getxSize(); ++i)
			for (int j = 0; j < b.getySize(); ++j)
				cells[i][j] = new Cell(i, j);
	}
	
	public static Board getInstance()
	{
		if (instance == null)
			return new Board();
		return instance;
	}
	

	
	public Cell[][] getCells() {
		return cells;
	}

	public Boardsize getB() {
		return b;
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
	

	
	public boolean  move(int x1, int y1, int x2, int y2,Cell initialpos,Cell finalpos)
	{ 
                    try{
		finalpos.setObject(initialpos.getObject());
			initialpos.setObject(null);
	return true;
                    }
                    catch(Exception ex){
                  return false;    	
                    }
	
	}
	
	public int getX()
	{
		return b.getxSize();
	}
	
	public int getY()
	{
		return b.getySize();
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