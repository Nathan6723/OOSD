package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Unit;
public class Menu {
	Scanner sc1=new Scanner(System.in);
	public Menu(){
		
		
	}
	

	
	public int[]  selectsteps(Unit u){


		 int[] steps=new int[2];
		String inp="";
		System.out.println(u.getName()+" turn");
		 if(u.getName()=="Scout"){
			System.out.println("You can move max 4 steps Vertical");
			System.out.println("Enter the num of steps that you want to  take");
		
		
				steps[0]=Integer.parseInt(sc1.nextLine());
				steps[0]=steps[0]-1;
				//steps[0]=3;
			
			steps[1]=0;
		 }
		
		if(u.getName()=="HenchMan"){
			System.out.println("You can move max 7 steps diagonally");
			//System.out.println("Enter the num of steps that you can take");
			
		System.out.println("Enter  the new x coordinates");
		
		steps[0]=Integer.parseInt(sc1.nextLine());
		
		System.out.println("Enter  the new y coordinates");
		steps[1]=Integer.parseInt(sc1.nextLine());
		
	
			
		    
		}
		if(u.getName()=="Soldier"){
			System.out.println("You can move max 7 steps Vertical and horizontal");
			//System.out.println("Enter the num of steps that you can take");
			
		System.out.println("Enter  the new x coordinates");
		
		steps[0]=Integer.parseInt(sc1.nextLine());
		
		System.out.println("Enter  the new y coordinates");
		steps[1]=Integer.parseInt(sc1.nextLine());
		
		
		//	steps[0]=Integer.parseInt(sc1.nextLine());		
			
		//	steps[0]=steps[0]-1;
			
			//System.out.println("enter y for horizontal and  x for vertical movement");
			
			//	inp=sc1.nextLine();
				//checkCorrdinate(inp, steps,steps[0]);
			
		    
		}
		
		
		
		if(u.getName()=="MarksMan"){
			System.out.println("You can move max 5 steps vertically");
			//System.out.println("Enter the num of steps that you can take");
			
		System.out.println("Enter  the new x coordinates");
		
		steps[0]=Integer.parseInt(sc1.nextLine());
		
	//	System.out.println("Enter  the new y coordinates");
		steps[1]=0;
	
			
		    
		}
		
		if(u.getName()=="Avatar"){
			System.out.println("You can move max 8  steps in any direction");
			//System.out.println("Enter the num of steps that you can take");
			
		System.out.println("Enter  the new x coordinates");
		
		steps[0]=Integer.parseInt(sc1.nextLine());
		
		System.out.println("Enter  the new y coordinates");
		steps[1]=Integer.parseInt(sc1.nextLine());
	
			
		    
		}
		
		
		
		if(u.getName()=="FireLord"){
			System.out.println("You can move max 6  steps in any direction");
			//System.out.println("Enter the num of steps that you can take");
			
		System.out.println("Enter  the new x coordinates");
		
		steps[0]=Integer.parseInt(sc1.nextLine());
		
		System.out.println("Enter  the new y coordinates");
		steps[1]=Integer.parseInt(sc1.nextLine());
	
			
		    
		}
		

		return steps;
	}
	

	public void  printunitposition(int x,int y,Unit u){
	
		System.out.println( u.getName()+" new position is"+x+","+y);
	}
	
	public String takeInput(){
		System.out.println("Do you want to continue say y for yes and n for no");
		String input=sc1.nextLine();
		
		return input;
	}
	
	public int SelectTurn(String player,ArrayList<Unit> unit){
		System.out.println(player +"turn" );
		System.out.println("select among the following units by line number" );
		
		int i=1;
		for(Unit u :unit){
			System.out.println(i+". "+u.getName());
			i++;
		}


int j= sc1.nextInt();
j--;
if(player.equals("Villians"))
	j=j+3;	

return j;
	}

}
