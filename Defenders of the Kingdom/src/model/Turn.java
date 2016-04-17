package model;

import java.util.Random;

import com.google.java.contract.Requires;

import controller.BoardController;

public class Turn
{
	private int turnNumber;
	private int currentPlayer;
	private boolean started = false;
	private boolean firstMove = true;
	private Player[] players;
	
	private BoardController boardController;
	
	public Turn(BoardController boardController)
	{
		this.boardController = boardController;
	}
	
	@Requires("setPlayers(Player[] players)")
	public void updateGame()
	{
		started = true;
		if (firstMove)
		{
			Random rand = new Random();
			currentPlayer = rand.nextInt(players.length);
			firstMove = false;
		}
		else 
			currentPlayer = currentPlayer == 0 ? 1 : 0;
		boardController.setStatus(players[currentPlayer].getName() + "'s turn:");
		++turnNumber;
	}
	
	public void setPlayers(Player[] players)
	{
		this.players = players;
	}
	
	public Player getCurrentPlayer()
	{
		return players[currentPlayer];
	}
	
	public boolean hasStarted()
	{
		return started;
	}
	
	public int getTurnNumber()
	{
		return turnNumber;
	}
}