package model;

public class Board
{
	private Cell[][] cells;
	private int xSize;
	private int ySize;
	public Board(int x, int y)
	{
		cells = new Cell[x][y];
		for (int i = 0; i < x; ++i)
			for (int j = 0; j < y; ++j)
				cells[i][j] = new Cell(i, j);
		this.xSize = x;
		this.ySize = y;
	}
	
	public void placeUnits(Player player)
	{
		Unit[] units = player.getTeam().getUnits();
		for (int i = 0; i < units.length; ++i)
			cells[units[i].getStartingX()][units[i].getStartingY()].setObject(units[i]);
	}
	
	public int getX()
	{
		return xSize;
	}
	
	public void setX(int x)
	{
		this.xSize = x;
	}
	public int getY()
	{
		return ySize;
	}
	public void setY(int y)
	{
		this.ySize = y;
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