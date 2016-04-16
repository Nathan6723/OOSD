package model;

public class FireLord extends Unit
{
	int lifelost;
	
	public FireLord() {
		
		name ="FireLord";
		attackRadius = 12;
		movementRadius = 5;
		health = 12;
		damage = 4;
		startingX = 6;
		startingY = 9;
		icon = 'F';
	
	}

	public void specialAttack(int health,int lifelost){
     
		this.health =+ lifelost;
	}

	@Override
	public 	 boolean isValidMove(int x1,int y1,int x2,int y2,Boardsize size) {
		Movement mov=Movement.getInstance();
		   if(  mov.negativehorizontal(x1, y1, x2, y2, movementRadius,size)|| mov.diagonal1(x1, y1, x2, y2, movementRadius,size)||mov.diagonal2(x1, y1, x2, y2, movementRadius,size)||mov.positivehorizontal(x1, y1, x2, y2, movementRadius,size)||mov.positiveVertical(x1, y1, x2, y2, movementRadius,size)||mov.negativeVertical(x1, y1, x2, y2, movementRadius,size))
			   return true;
		   else 
			   return false;
	}
	
	
}
