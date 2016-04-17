package model;

public class Henchman extends Unit
{
	public Henchman()
	{
		name= "Henchman";
		attackRadius = 3;
		movementRadius = 2;
		health = 9;
		damage = 4;
		startingX = 2;
		startingY = 4;
		icon = 'H';
	}


public int doubleAttackRadius(int r ){
	return 2*r;
	
}


	

}
