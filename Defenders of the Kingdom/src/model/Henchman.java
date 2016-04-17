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
		teamName = "Villians";
	}


public int doubleAttackRadius(int r ){
	return 2*r;
	
}


@Override
public boolean moveUnit(Cell initialpos, Cell finalpos, Board b) {
	CheckMovement mov=	CheckMovement.getInstance();
	   if(   mov.diagonal1(initialpos, finalpos,this,b)||mov.diagonal2(initialpos, finalpos,this,b))
		   return true;
	   else 
		   return false;
}


	

}
