package model;

import java.util.ArrayList;

public class Soldier extends Unit
{
	
	private boolean attackflag;
	public Soldier(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	  this.attackflag=false;
	}
	
	//special power
	public void attackAll(ArrayList<Unit> unit){
		
		for(Unit u:unit)
			u.setDamage(2);
		this.attackflag=true;
		
	}
	
}
