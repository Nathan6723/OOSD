package model;

public class Marksman extends Unit
{
	
	
	public Marksman(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	}
	public  int doubleDamage(int damage){
		return 2*damage;	
	}
	
	
}
