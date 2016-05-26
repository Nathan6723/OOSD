package model;

import java.util.ArrayList;

import model.board.Board;

public class Undo
{
	ArrayList<Board> boards = new ArrayList<>();
	
	public Board undoMove()
	{
		int whichBoard = boards.size() - 2;
		if (whichBoard < 0 || whichBoard >= boards.size())
			return null;
		Board board = boards.get(whichBoard);
		boards.remove(whichBoard);
		try
		{
			boards.remove(whichBoard + 1);
		}
		catch (IndexOutOfBoundsException e) {}
		return board;
	}
	
	public void storeMove(Board board)
	{
		boards.add(board.copyBoard());
	}
}
