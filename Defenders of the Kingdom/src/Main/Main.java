package Main;

import java.awt.Menu;
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
//	public static Scanner sc   =new Scanner(System.in);
	public static void main(String args[])
	{   
        
	    view.Menu menu  =new     view.Menu();
		String inp="";
		GameController game = new GameController();
		game.initialisePlayers();
		TurnController turn = new TurnController();
		Board board = new Board(10, 10);
		Player[] player= game.getPlayer();
	//	board.placeUnits(player[0],player[1]);
		board.placeUnits(player);
		Unit[] units=game.getUnit();
		
		Draw drawer = new Draw();
		boolean running =true;
		Cell[][] cell=board.getAllCells();
		turn.setTurnNumber(-1);
		 turn.incrementTurnNumber();
		while (running)
		{    
		   int turnflag=turn.getTurnNumber();
			drawer.drawBoard(board, game.getPlayers());
			System.out.println("Game starts");
		     if(turnflag==6)
		    	 break;
		    	//turn.setTurnNumber(2);
		    
		    	
		 //    if(turnflag==0){
		    	 
		    if(turnflag==0||turnflag==3||turnflag==1||turnflag==4||turnflag==2||turnflag==5){
		 	  cell[units[turnflag].getStartingX()][units[turnflag].getStartingY()].setUnit(null);
			    int[]  steps=  menu.selectsteps(units[turnflag]);
			       if(board.checkBounds(steps[0], steps[1]))
			    	  // if(turnflag==turnflag)
			    	   units[turnflag].move(steps[0],steps[1]);
			       menu.printunitposition(units[turnflag].getStartingX(),units[turnflag].getStartingY(),units[turnflag]);
			       cell[units[turnflag].getStartingX()][units[turnflag].getStartingY()].setUnit(units[turnflag]);
			  
		    }
		    
			 turn.setTurnNumber(turnflag);
			 turn.setTurn();
		    
		         // if(turnflag==4)
			       //break;
		  	// turn.incrementTurnNumber();	
		    		/*System.out.println("Scount turn");
		    		  cell[units[0].getStartingX()][units[0].getStartingY()].setUnit(null);
		    		  //4 units diagonally
		    		  if(board.checkBounds(units[0].getStartingX()+4, units[2].getStartingY(), board))
		              units[0].move(units[0].getStartingX()+4,units[0].getStartingY());
		            System.out.println("scout's new position"+units[0].getStartingX()+","+units[2].getStartingY());      		 
		           cell[units[0].getStartingX()][units[0].getStartingY()].setUnit(units[0]);
		          
		        	drawer.drawBoard(board, game.getPlayers());
		    		System.out.println("Do you want to use attack y or n");
		    		
		              inp="y";
		    		 if(inp.toLowerCase().contains("y")){
		    		System.out.println("scanned input");
		    			 units[2].attack(board,units[2]);
		    	 
		    		
		     } */
		//     }
		    		 
		    	/* if(turnflag==7){
				    		System.out.println("villians's turn");
				    		  cell[units[3].getStartingX()][units[3].getStartingY()].setUnit(null);
				    		  if(board.checkBounds(units[2].getStartingX()+4, units[2].getStartingY(), board))
				              units[3].move(units[3].getStartingX()-3,units[3].getStartingY());
				            System.out.println("villian's new position"+units[3].getStartingX()+","+units[3].getStartingY());      		 
				           cell[units[3].getStartingX()][units[3].getStartingY()].setUnit(units[3]);
				          
				        	drawer.drawBoard(board, game.getPlayers());
				    		System.out.println("Do you want to use attack y or n");
				    	
				    	     inp="y";
				    		 if(inp.toLowerCase().contains("y")){
				    			 //int attackradius=units[2].getAttackRadius();
				    			System.out.println("scanned input");
				    			 units[3].attack(board,units[3]);
				    			//  turn.incrementTurnNumber();
				    			  
				            //turn.moveUnit(x1, y1, x2, y2)
				     } 	 
		    		 
				    		 
		    		 }*/
		
		    		//	 System.out.println("Following opponents are in your range Whom do  you want to attack ");
		    		  //    board.getCell(attackradius,attackradius);
		    			// running=false;
		    	 
		    		
		
		    }
		drawer.drawBoard(board, game.getPlayers());
		
			
			/*for (int i = 0; i < numPlayers; ++i)
				turn.run(players[0]);*/
		}
	}
