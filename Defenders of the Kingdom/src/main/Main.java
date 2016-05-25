package main;

import controller.BoardController;
import model.board.Board;
import view.BoardView;

public class Main
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{   
		Board board = new Board();
		BoardView boardView = new BoardView(board);
		BoardController boardController = new BoardController(board, boardView);
	}
}