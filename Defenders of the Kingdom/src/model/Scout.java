package model;


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
	}
	
	
	//attack Any
	public void specialAttack(){
		

		/*	System.out.println("Choose any Villian on the board to attack");
		
		Scanner sc = new Scanner(System.in);
			int opponentX = sc.nextInt();
			
		Scanner scn  = new Scanner(System.in);
			
			int opponentY = scn.nextInt();
			
		
			// Unit opponent;
			
			if (opponent instanceof FireLord || opponent instanceof Henchman || opponent instanceof Marksman) {
			
			
			this.specialAttack(opponentX, opponentY);
			
			this.cannotUseSpecialPower = true;
			
			
		}*/
	}


	@Override
	public  boolean isValidMove(int x1,int y1,int x2,int y2,Boardsize  size) {
		Movement mov=Movement.getInstance();
		if(mov.positiveVertical(x1, y1, x2, y2, movementRadius,size)||mov.negativeVertical(x1, y1, x2, y2, movementRadius,size))
			return true;
	else
		return false;
	}
}
