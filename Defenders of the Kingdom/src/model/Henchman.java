package model;

public class Henchman extends Unit
{

	
	public Henchman()
	{
		name= "HenchMan";
		attackRadius = 3;
		movementRadius = 2;
		health = 9;
		damage = 4;
		startingX = 9;
		startingY = 6;
		icon = 'H';
	}


public int doubleAttackRadius(int r ){
	return 2*r;
	
}


@Override
public   boolean isValidMove(int x1,int y1,int x2,int y2,Boardsize size) {
	Movement mov=Movement.getInstance();
	   if(   mov.diagonal1(x1, y1, x2, y2, movementRadius,size)||mov.diagonal2(x1, y1, x2, y2, movementRadius,size))
		   return true;
	   else 
		   return false;

	
}


	

}
