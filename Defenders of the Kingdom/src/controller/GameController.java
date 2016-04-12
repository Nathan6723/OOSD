package controller;

import java.util.Random;
import java.util.Scanner;

import model.Avatar;
import model.Board;
import model.FireLord;
import model.Heroes;
import model.Player;
import model.Scout;
import model.Soldier;
import model.Team;
import model.Unit;
import model.Villians;
import view.Draw;
import model.Henchman;
import model.Marksman;

public class GameController
{
	public static final int numPlayers = 2;
	public static final int numUnits= 6;
	
	private Player[] players;
	private Unit[] units;
	
	public Player[] getPlayers()
	{
		return players;
	}

	public void setPlayers(Player[] players)
	{
		this.players = players;
	}
	
	public void intializeUnits(){
		units=new Unit[numUnits];
		units[0]=new Scout("Scout",2,3,3,true,0,4,'c');
		units[1]=new Soldier("Soldier",6,7,3,true,0,5,'S');
		units[2]=new Avatar("Avatar",14,10,4,true,0,6,'A');
		units[3]=new Henchman("HenchMan",3,9,4,true,9,4,'H');
		units[4]=new Marksman("MarksMan",8,8,4,true,9,5,'M');
		units[5]=new FireLord("FireLord",9,12,5,true,9,6,'F');
		
	}

	public void initialisePlayers()
	{	intializeUnits();
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
			//players[whichPlayer].setHeroes(new Heroes("Heroes"));
			players[whichPlayer].setTeam(new Team("Heroes"));
		//Heroes heroes=players[whichPlayer].getHeroes();
		Team objheroes= players[whichPlayer].getTeam();
		for(int i=3;i<6;i++){
		//	heroes.setUnits(units[i]);
			objheroes.setUnit(units[i]);
			//players[whichPlayer].getTeam().setUnit(units[i]);
			}
			//players[whichPlayer-1].setVillians(new Villians("Villians"));
			//players[whichPlayer-1].setTeam(new Villians("Villians"));
			players[whichPlayer-1].setTeam(new Team("Villians"));
			//Villians villians=(Villians)players[whichPlayer-1].getVillians();
			Team objvillians= players[whichPlayer-1].getTeam();
			for(int j=0;j<3;j++){
				//villians.setUnits(units[j]);
				objvillians.setUnit(units[j]);
				//players[whichPlayer-1].getTeam().setUnit(units[i]);
			}
		}
		else if (whichTeam==2)
		{
			//players[whichPlayer].setVillians(new Villians("Villians"));
		//	players[whichPlayer].setTeam(new Villians("Villians"));
			players[whichPlayer].setTeam(new Team("Villians"));
		//	Villians villians=(Villians)players[whichPlayer].getVillians();
			Team objvillians= players[whichPlayer].getTeam();
			for(int i=3;i<6;i++){
			//	villians.setUnits(units[i]);
				objvillians.setUnit(units[i]);
				//players[whichPlayer].getTeam().setUnit(units[i]);
				}
			//players[whichPlayer-1].setHeroes(new Heroes("Heroes"));
			players[whichPlayer-1].setTeam(new Team("Heroes"));
			//players[whichPlayer-1].setTeam(new Heroes("Heroes"));
			//Heroes heroes=(Heroes)players[whichPlayer-1].getHeroes();
			Team objheroes= players[whichPlayer-1].getTeam();
			for(int i=0;i<3;i++){
			//	heroes.setUnits(units[i]);
				objheroes.setUnit(units[i]);
			//players[whichPlayer-1].getTeam().setUnit(units[i]);
			}
		}
	//	scan.close();
	}
	
	public Player[] getPlayer(){
		
		return players;
	}
	
	public Unit[] getUnit(){
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