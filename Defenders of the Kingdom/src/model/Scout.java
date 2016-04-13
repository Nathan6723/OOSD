package model;
import java.util.Scanner;

public class Scout extends Unit
{
	
	public Scout(){
		super();	
		name = "Scout";
		attackRadius = 2;
		health = 3;
		damage = 2;
		startingX = 4;
		startingY = 8;
		icon = 'C';
	}
	
	
	
	public void specialAttack(){
		
		System.out.println("Choose any Villian on the board to attack");
		
		Scanner sc = new Scanner(System.in);
			int opponentX = sc.nextInt();
			
		Scanner scn  = new Scanner(System.in);
			
			int opponentY = scn.nextInt();
			
		
			// Unit opponent;
			
		
		if (opponent instanceof FireLord || opponent instanceof Henchman || opponent instanceof Marksman) {
			
			
			this.attack(opponentX, opponentY);
			
			this.cannotUseSpecialPower = true;
			
			
		}
	}
}
