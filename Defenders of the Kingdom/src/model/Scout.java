package model;
import java.util.Scanner;

public class Scout extends Unit
{
	
	public Scout(){
		super();	
		name = "Scout";
		attackRadius = 2;
		movementRadius = 3;
		health = 3;
		damage = 2;
		startingX = 4;
		startingY = 8;
		icon = 'C';
		teamName = "Heroes";
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
	

	@Override
	public boolean moveUnit(Cell initialpos, Cell finalpos, Board b) {
		CheckMovement mov=	CheckMovement.getInstance();
		if(mov.positivehorizontal(initialpos, finalpos,this,b)||mov.positiveVertical(initialpos, finalpos,this,b)||mov.positiveVertical(initialpos, finalpos,this,b)||mov.negativeVertical(initialpos, finalpos,this,b))
			return true;
	else
		return false;
	}
}

	
	

