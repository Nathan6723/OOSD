package controller;

import model.Board;
import model.Turn;
import view.BoardView;

public class BoardController
{
	private Board board;
	private BoardView boardView;
	private Turn turn = new Turn();

	public BoardController(Board board, BoardView boardView)
	{
		this.board = board;
		this.boardView = boardView;
		boardView.setController(this);
	}
	
	public boolean moveUnit(int x1, int y1, int x2, int y2)
	{
		return board.moveUnit(x1, y1, x2, y2);
	}
	
	public String getNextMessage()
	{
		return turn.getNextMessage();
	}
	
	public void processInput(String input)
	{
		turn.processInput(input);
	}
}
