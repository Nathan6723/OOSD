package model;

public class Marksman extends Unit
{
	
	
	public Marksman() {
		
		name= "Marksman";
		attackRadius = 3;
		movementRadius = 2;
		health = 7;
		damage = 1;
		startingX = 4;
		startingY = 3;
		icon = 'M';
		
	}
	public  int doubleDamage(int damage){
		return 2*damage;	
	}
	@Override
	public  boolean isValidMove(int x1,int y1,int x2,int y2,Boardsize size) {
		Movement mov=Movement.getInstance();
		   if(   mov.diagonal1(x1, y1, x2, y2, movementRadius,size)||mov.diagonal2(x1, y1, x2, y2, movementRadius,size)||mov.positiveVertical(x1, y1, x2, y2, movementRadius,size)||mov.negativeVertical(x1, y1, x2, y2, movementRadius,size))
			   return true;
		   else 
			   return false;

	}
	
	
}
