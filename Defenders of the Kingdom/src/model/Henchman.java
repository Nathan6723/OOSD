package model;

public class Henchman extends Unit
{

	
	public Henchman(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	
	}


public int doubleAttackRadius(int r ){
	return 2*r;
	
}


	

}
