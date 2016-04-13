package view;

import model.Board;
import model.Player;
import model.Unit;

public class OldBoardView
{
	public void drawBoard(Board board, Player[] players)
	{
		for (int i = 0; i < players.length; ++i)
			System.out.println(players[i].getName() + " : " + players[i].getTeam().getName());
		for (int i = 0; i < board.getY(); ++i)
		{
			System.out.print(i);
			for (int j = 0; j < board.getX(); ++j)
			{
				Object object = board.getCell(i,j).getObject();
				if(object != null)
					System.out.print("[" + board.getCell(i, j).getObject().getIcon() + "]");
				else
					System.out.print("[ ]");
			}
			System.out.println();
		}
		for (int i = 0; i < board.getX(); ++i)
			System.out.print("  " + i);
	}
	
	public boolean drawObject(Object object, int x, int y)
	{
		
		return true;
	}
	
	public void printText(String text)
	{
		System.out.println(text);
	}
}