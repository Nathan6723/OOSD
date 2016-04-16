package Main;

import java.util.Scanner;

import controller.BoardController;

import model.Board;
import model.Boardsize;
import model.Cell;
import model.Heroes;
import model.Player;
import model.Unit;
import model.Villians;
import view.BoardView;


public class Main
{
	public static int numPlayers=2;
	public static void main(String[] args)
	{  
		Board board = Board.getInstance();
		Player[] players = new Player[2];
		for (int i = 0; i < players.length; ++i)
			players[i] = new Player();
		players[0].setName("Player1");
		players[0].setTeam(new Heroes());
		players[1].setName("Player2");
		players[1].setTeam(new Villians());
		board.placeUnits(players);
		BoardView boardView = new BoardView(board);
		BoardController boardController = new BoardController(board, boardView);
		
	}
}