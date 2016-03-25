package controller;

import java.util.Random;
import java.util.Scanner;

import model.Board;
import model.Heroes;
import model.Player;
import model.Team;
import model.Villians;
import view.Draw;
// C
public class GameController
{
	public static final int numPlayers = 2;
	private Player[] players;
	
	public Player[] getPlayers()
	{
		return players;
	}

	public void setPlayers(Player[] players)
	{
		this.players = players;
	}

	public void initialisePlayers()
	{
		players = new Player[numPlayers];
		for (int i = 0; i < numPlayers; ++i)
			players[i] = new Player();
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < numPlayers; ++i)
		{
			System.out.println("Player " + (i+1) + " Enter your name:");
			String name = scan.nextLine();
			players[i].setName(name);
		}
		Random rand = new Random();
		int whichPlayer = rand.nextInt(numPlayers);
		int whichTeam = 0;
		while (true)
		{
			try
			{
				System.out.println("Enter your team " + players[whichPlayer].getName()
						+ ":" + "\n1. Heroes" + "\n2. Villians");
				whichTeam = Integer.parseInt(scan.nextLine());
				break;
			}
			catch (Exception e)
			{
				System.out.println("Invalid team number");
			}
		}
		if (whichTeam == 1)
		{
			players[whichPlayer].setTeam(new Heroes());
			players[whichPlayer == 0 ? 1 : 0].setTeam(new Villians());
		}
		else if (whichTeam == 2)
		{
			players[whichPlayer].setTeam(new Villians());
			players[whichPlayer == 0 ? 1 : 0].setTeam(new Heroes());
		}
		scan.close();
	}
	
	public boolean pause()
	{
		return true;
	}
	
	public boolean unpause()
	{
		return true;
	}
	
	public void exit()
	{
		System.exit(0);
	}
}