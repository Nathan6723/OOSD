package controller;

import java.util.Random;
import java.util.Scanner;

import model.Board;
import model.Heroes;
import model.Player;
import model.Team;
import model.Unit;
import model.Villians;
import view.Draw;

public class GameController
{
	public static final int numPlayers = 2;
	public static final int numUnits= 6;
	
	private Player[] players;

	private static GameController instance = null;
	
	private GameController() {}
	
	public static GameController GetInstance()
	{
		if (instance == null)
			instance = new GameController();
		return instance;
	}

	private Unit[] units;
	
	public Player[] getPlayers()
	{
		return players;
	}

	public void setPlayers(Player[] players)
	{
		this.players = players;
	}
	
	public void intializeUnits()
	{
		units=new Unit[numUnits];
		units[0]=new Unit("Hero",14,10,4,true,0,4,'H');
		units[1]=new Unit("Soldier",6,7,3,true,0,5,'S');
		units[2]=new Unit("Scout",2,3,3,true,0,6,'c');
		units[3]=new Unit("Villian",12,12,5,true,9,4,'V');
		units[4]=new Unit("MarksMan",8,8,4,true,9,5,'M');
		units[5]=new Unit("HenchMan",3,9,4,true,9,6,'E');
	}

	public void initialisePlayers()
	{
		intializeUnits();
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
		whichPlayer=1;
		System.out.println(whichPlayer);
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
			players[whichPlayer].setHeroes(new Heroes("Heroes"));
			players[whichPlayer].setTeam(new Heroes("Heroes"));
		Heroes heroes=players[whichPlayer].getHeroes();
		for(int i=3;i<6;i++){
			heroes.setUnits(units[i]);
			//players[whichPlayer].getTeam().setUnit(units[i]);
			}
			players[whichPlayer-1].setVillians(new Villians("Villians"));
			players[whichPlayer-1].setTeam(new Villians("Villians"));
			Villians villians=(Villians)players[whichPlayer-1].getVillians();
			for(int j=0;j<3;j++){
				villians.setUnits(units[j]);
				//players[whichPlayer-1].getTeam().setUnit(units[i]);
			}
		}
		else if (whichTeam==2)
		{
			players[whichPlayer].setVillians(new Villians("Villians"));
			players[whichPlayer].setTeam(new Villians("Villians"));
			
			Villians villians=(Villians)players[whichPlayer].getVillians();
			for(int i=3;i<6;i++){
				villians.setUnits(units[i]);
				//players[whichPlayer].getTeam().setUnit(units[i]);
				}
			players[whichPlayer-1].setHeroes(new Heroes("Heroes"));
			players[whichPlayer-1].setTeam(new Heroes("Heroes"));
			Heroes heroes=(Heroes)players[whichPlayer-1].getHeroes();
			for(int i=0;i<3;i++){
				heroes.setUnits(units[i]);
			//players[whichPlayer-1].getTeam().setUnit(units[i]);
			}
		}
		scan.close();
	}
	
	public Player[] getPlayer()
	{
		
		return players;
	}
	
	public Unit[] getUnit()
	{
		 return units;
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