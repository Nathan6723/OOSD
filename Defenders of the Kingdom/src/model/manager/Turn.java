package model.manager;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.java.contract.Requires;

import controller.BoardController;
import model.player.Player;

public class Turn
{
	private int numTurns;
	private int currentPlayer;
	private boolean started = false;
	private boolean firstMove = true;
	private Player[] players;
	
	@JsonIgnore
	private BoardController boardController;

	public Turn() {}
	
	public Turn(BoardController boardController)
	{
		this.boardController = boardController;
	}
	
	public void setBoardController(BoardController boardController)
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
		setStatus();
		++numTurns;
	}
	
	public void setStatus()
	{
		boardController.setStatus(players[currentPlayer].getName() + "'s turn:");
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	public void setPlayers(Player[] players)
	{
		this.players = players;
	}
	
	public Player currentTurnPlayer()
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
	
	public int getNumTurns()
	{
		return numTurns;
	}
}
