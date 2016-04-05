package view;

import model.Board;
import model.Player;

public class Draw
{
	public void drawBoard(Board board, Player[] players)
	{
		for (int i = 0; i < players.length; ++i)
			System.out.println(players[i].getName() + " : " + players[i].getTeam().getName());
		for (int i = 0; i <board.getX(); ++i)
		{
			System.out.print(i);
			for (int j = 0; j < board.getY(); ++j)
			if(board.getCell(i,j).getUnit()!=null){
				System.out.print("["+board.getCell(i, j).getUnit().getIcon()+"]");	
			}
			else if(board.getCell(i,j).getUnit()==null){
				System.out.print("[ ]");
			}
			System.out.println();
		}
		for (int i = 0; i < board.getY(); ++i)
			System.out.print("  " + i);
		
		
	}
	
	public boolean drawObject(Object object)
	{
		
		return true;
	}
	
	public void printText(String text)
	{
		
	}
}