package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.GameController;
import controller.TurnController;
import model.Board;
import model.Cell;
import model.Player;
import model.Unit;
import view.Draw;

public class Main
{   //private   static int t =0;
	public static void main(String args[])
	{   
	
		GameController game = new GameController();
		game.initialisePlayers();
		TurnController turn = new TurnController();
		Board board = new Board(10, 10);
		Player[] player= game.getPlayer();
		board.placeUnits(player[0],player[1]);
		Unit[] units=game.getUnit();
		
		Draw drawer = new Draw();
		boolean running = true;
		Cell[][] cell=board.getAllCells();
		while (running)
		{
			drawer.drawBoard(board, game.getPlayers());
			System.out.println("Game starts");
		     if(turn.getTurnNumber()==-1)
		    	 break;
		     
		     
		     if(turn.getTurnNumber()==0){
		    		System.out.println("Scount turn");
		    		  cell[units[2].getStartingX()][units[2].getStartingY()].setUnit(null);
		              units[2].move(units[2].getStartingX()+4,units[2].getStartingY());
		            System.out.println("scout's new position"+units[2].getStartingX()+","+units[2].getStartingY());      		 
		           cell[units[2].getStartingX()][units[2].getStartingY()].setUnit(units[2]);
		          
		           
		            //turn.moveUnit(x1, y1, x2, y2)
		     } 
		    		
		    		
		    		System.out.println("Do you want to use attack y or n");
		    		Scanner sc=new Scanner(System.in);
		    		String inp="y";
		    		 if(inp.toLowerCase().contains("y")){
		    			 //int attackradius=units[2].getAttackRadius();
		    			System.out.println("scanned input");
		    			 units[2].attack(board,units[2]);
		    			 
		    		//	 System.out.println("Following opponents are in your range Whom do  you want to attack ");
		    		  //    board.getCell(attackradius,attackradius);
		    			 
		    		 }
		    		 else{
		    			 
		    			 
		    		 }
		
		     }
		drawer.drawBoard(board, game.getPlayers());
		
			
			/*for (int i = 0; i < numPlayers; ++i)
				turn.run(players[0]);*/
		}
	}

