package main;

import java.util.Scanner;

import controller.BoardController;
import controller.GameController;
import model.Board;
import model.Cell;
import model.Player;
import model.Unit;
import view.BoardView;
import view.OldBoardView;

public class Main
{
	public static void main(String[] args)
	{   
		Board board = Board.getInstance();
		BoardView boardView = new BoardView();
		BoardController boardController = new BoardController(board, boardView);
	}
}