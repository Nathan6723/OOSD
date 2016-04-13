package model;

public class Henchman extends Unit
{

	
	public Henchman()
	{
		name= "HenchMan";
		attackRadius = 3;
		health = 9;
		damage = 4;
		startingX = 9;
		startingY = 6;
		icon = 'E';
	}


public int doubleAttackRadius(int r ){
	return 2*r;
	
}


	

}
