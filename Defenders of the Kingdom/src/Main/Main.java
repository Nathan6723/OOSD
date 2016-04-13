package Main;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import model.Board;
import model.Cell;
import model.GameController;
import model.Player;
import model.TurnController;
import model.Unit;
import view.Draw;

public class Main
{   //private   static int t =0;
//	public static Scanner sc   =new Scanner(System.in);
	public static void main(String args[])
	{   
        
	    view.Menu menu  =new     view.Menu();
		GameController game = new GameController();
		game.initialisePlayers();
		TurnController turn = new TurnController();
		Board board = new Board(10, 10);
		Player[] player= game.getPlayer();
		board.placeUnits(player);
		Unit[] units=game.getUnit();
	
		Draw drawer = new Draw();
		boolean running =true;
		Cell[][] cell=board.getAllCells();
		turn.setTurnNumber(-1);
		 turn.incrementTurnNumber();
		//menu.SelectTurn(player[0].getTeam().getName(),)
		while (running)
		{    
		   int turnflag=turn.getTurnNumber();
			drawer.drawBoard(board, game.getPlayers());
			System.out.println("Game starts");
		     if(turnflag==6){
		    	 
		    	 if(menu.takeInput().equals("n"))
		    	 break;
		    	 else{
		    		turn.setTurnNumber(0);
		    		turnflag=turn.getTurnNumber();
		    		}
		     }
		    	 	    	 
		  //	turn.setTeamTurn(player[0].getTeam(),player[1].getTeam(), currentunit, units)
		     
		     
		     cell[units[turnflag].getStartingX()][units[turnflag].getStartingY()].setUnit(null);
			    int[]  steps=  menu.selectsteps(units[turnflag]);
			       if(board.checkBounds(steps[0],steps[1]))			    	 
			    	   units[turnflag].move(steps[0],steps[1]);
			       menu.printunitposition(units[turnflag].getStartingX(),units[turnflag].getStartingY(),units[turnflag]);
			       cell[units[turnflag].getStartingX()][units[turnflag].getStartingY()].setUnit(units[turnflag]);	    
			 turn.setTurnNumber(turnflag);
			 turn.setTurn();
		    units[turnflag].attack(board,units[turnflag]);
		
		    	
		    	 
		    		
		
		    }
		drawer.drawBoard(board, game.getPlayers());
		
			
			
		}
	}

