package model;

public class Scout extends Unit
{
	
	private boolean attackflag;
	public Scout(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	}

	
	
//attacks anyone at any distance
	public void attackAnyDistance(){
		
		attackflag=true;
		
	}
	}
	

