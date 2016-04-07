package model;

import java.util.ArrayList;

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
	
	public void placeUnits(Player player1,Player player2)
	{		ArrayList<Unit> units=new ArrayList<Unit>() ;
	ArrayList<Unit> units1=new ArrayList<Unit>() ;
		// Team t=new Team();
		if(player1.getHeroes()!=null){
	     units = player1.getHeroes().getUnits();
	     units1=player2.getVillians().getUnits();
		}
			else  if(player1.getVillians()!=null){
		 units = player1.getVillians().getUnits();
		 units1 = player2.getHeroes().getUnits();
			}
			
		for (int i = 0; i < units.size(); ++i){
			cells[units.get(i).getStartingX()][units.get(i).getStartingY()].setUnit(units.get(i));
		System.out.println(cells[units.get(i).getStartingX()][units.get(i).getStartingY()].getUnit().getName());
		}
		for (int i = 0; i < units1.size(); ++i){
			cells[units1.get(i).getStartingX()][units1.get(i).getStartingY()].setUnit(units1.get(i));
		System.out.println(cells[units1.get(i).getStartingX()][units1.get(i).getStartingY()].getUnit().getName());
		
		}
	}
		//System.out.println();

	
	
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