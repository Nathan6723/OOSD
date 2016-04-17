package model;

import java.util.Iterator;
import java.util.Random;

import controller.BoardController;

public class PlayerCreator
{
	private Player[] players = new Player[2];
	private BoardController boardController;
	
	public PlayerCreator(BoardController boardController)
	{
		this.boardController = boardController;
		for (int i = 0; i < players.length; ++i)
			players[i] = new Player();
	}
	
	public boolean createPlayers()
	{
		for (int i = 0; i < players.length; ++i)
		{
			String name = null;
			do
			{
				name = boardController.getInput("Enter your name Player " + (i + 1) + ":");
				if (name == null)
					return false;
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
		int whichPlayer = rand.nextInt(players.length);
		int team = boardController.getChoice("Team", "Choose your team " + players[whichPlayer].getName() + ":", options);
		if (team == 0)
		{
			players[whichPlayer].setTeam(new Heroes());
			players[whichPlayer == 0 ? 1 : 0].setTeam(new Villians());
		}
		else if (team == 1)
		{
			players[whichPlayer].setTeam(new Villians());
			players[whichPlayer == 0 ? 1 : 0].setTeam(new Heroes());
		}
		else
			return false;
		for (int i = 0; i < players.length; ++i)
		{
			Iterator<Unit> iter = players[i].getTeam().getUnits().iterator();
			while (iter.hasNext())
				iter.next().setTeam(players[i].getTeam());
		}
		return true;
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
}
