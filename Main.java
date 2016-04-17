package main;


import controller.BoardController;
import model.Board;
import view.BoardView;

public class Main
{
	public static void main(String[] args)
	{   
		Board board = Board.getInstance();
		BoardView boardView = new BoardView(board);
		BoardController boardController = new BoardController(board, boardView);
	}
}