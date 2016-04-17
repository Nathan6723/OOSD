package model;
import java.util.Scanner;

public class Scout extends Unit
{	
	public Scout()
	{
		name = "Scout";
		attackRadius = 2;
		movementRadius = 3;
		health = 3;
		damage = 2;
		startingX = 9;
		startingY = 7;
		icon = 'C';
	}
	
	
	
	public void specialAttack(){
		
		System.out.println("Choose any Villian on the board to attack");
		
		Scanner sc = new Scanner(System.in);
			int opponentX = sc.nextInt();
			
		Scanner scn  = new Scanner(System.in);
			
			int opponentY = scn.nextInt();
			
		
			// Unit opponent;

			this.cannotUseSpecialPower = true;

	}
}
