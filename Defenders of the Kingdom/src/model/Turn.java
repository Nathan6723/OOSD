package model;

import java.util.Random;

import controller.BoardController;

public class Turn
{
	private int turnNumber;
	private int currentPlayer;
	private Player[] players = new Player[2];
	private boolean started = false;
	
	private BoardController boardController;
	
	public Turn(BoardController boardController)
	{
		this.boardController = boardController;
		for (int i = 0; i < players.length; ++i)
			players[i] = new Player();
	}

	public Player setUpPlayers()
	{
		for (int i = 0; i < players.length; ++i)
		{
			String name = null;
			do
			{
				name = boardController.getInput("Enter your name Player " + (i + 1) + ":");
				name = name.trim();
			}
			while (name.equals(""));
			players[i].setName(name);
		}

		String[] options = new String[3];
		options[0] = "Heroes";
		options[1] = "Villians";
		options[2] = "Cancel";
		Random rand = new Random();
		currentPlayer = rand.nextInt(players.length);
		int team = boardController.getChoice("Team", "Choose your team " + players[currentPlayer].getName() + ":", options);
		if (team == 0)
		{
			players[currentPlayer].setTeam(new Heroes());
			players[currentPlayer == 0 ? 1 : 0].setTeam(new Villians());
		}
		else if (team == 1)
		{
			players[currentPlayer].setTeam(new Villians());
			players[currentPlayer == 0 ? 1 : 0].setTeam(new Heroes());
		}
		currentPlayer = rand.nextInt(players.length);
		boardController.printMessage(players[currentPlayer].getName() + "'s turn:");
		++turnNumber;
		started = true;
		return players[currentPlayer];
	}
	
	public void updateGame()
	{
		currentPlayer = currentPlayer == 0 ? 1 : 0;
		boardController.printMessage(players[currentPlayer].getName() + "'s turn:");
		++turnNumber;
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	public Player getCurrentPlayer()
	{
		return players[currentPlayer];
	}
	
	public boolean hasStarted()
	{
		return started;
	}
	
	public void setStarted(boolean started)
	{
		this.started = started;
	}
	
	public int getTurnNumber()
	{
		return turnNumber;
	}
}