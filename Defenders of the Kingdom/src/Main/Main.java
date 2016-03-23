package Main;

import controller.GameController;
import controller.TurnController;
import model.Board;
import view.Draw;

public class Main
{
	public static void main(String args[])
	{
		GameController game = new GameController();
		game.initialisePlayers();
		TurnController turn = new TurnController();
		Board board = new Board(10, 10);
		Draw drawer = new Draw();
		boolean running = true;
		while (running)
		{
			drawer.drawBoard(board, game.getPlayers());
			break;
			/*for (int i = 0; i < numPlayers; ++i)
				turn.run(players[0]);*/
		}
	}
}
