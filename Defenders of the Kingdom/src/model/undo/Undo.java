package model.undo;

import java.util.ArrayList;

import model.board.Board;

public class Undo
{
	ArrayList<Board> boards = new ArrayList<>();
	
	private final static int NUM_MOVES = 3;
	private final static int NUM_STORED = 10;
	
	// Go back by one move
	public Board undoMove()
	{
		int whichBoard = boards.size() - NUM_MOVES;
		if (whichBoard < 0 || whichBoard >= boards.size())
			return null;
		Board board = boards.get(whichBoard);
		for (int i = 0; i < NUM_MOVES; ++i)
			boards.remove(whichBoard);
		boards.add(board.copyBoard());
		return board;
	}
	
	public void storeMove(Board board)
	{
		if (boards.size() == NUM_STORED)
			boards.remove(0);
		boards.add(board.copyBoard());
	}
}
