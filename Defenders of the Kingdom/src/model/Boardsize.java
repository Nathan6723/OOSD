package model;

import Interfaces.Object;

public class Boardsize {
	private static int  xSize=10;
	private static int  ySize=10;
	
	public Boardsize() {
	
	}
	//checks the movement is within  the bounds of the board
	public boolean checkBounds(int x,int y){
		
		if((x<xSize)&&(y<ySize))
		return true;
		else 
			return false;
	}

public boolean isValidMove(int x1,int y1,int x2,int y2,Board b){
	if (x1 == x2 && y1 == y2)
		return false;
	Cell[][] cells=b.getAllCells();
	Cell initial_pos = cells[x1][y1];
	Object obj1 = initial_pos.getObject();
	if (obj1 == null || !(obj1 instanceof Unit))
		return false;
	Cell final_pos = cells[x2][y2];
	Object obj2 = final_pos.getObject();
	if (obj2 != null)
		return false;
	Unit unit = (Unit)obj1;
	int distance = Math.abs(final_pos.getY() - initial_pos.getY())
		+ Math.abs(final_pos.getX() - initial_pos.getX());
	if (unit.getMovementRadius() >= distance){
		if(unit.isValidMove(x1, y1, x2, y2,this))
			b.move(x1, y1, x2, y2,initial_pos,final_pos);
		else 
			return false;
	}
	
	return false;
	
}











	
	public int getxSize() {
		return xSize;
	}

	

	public int getySize() {
		return ySize;
	}

	


	
	
}
