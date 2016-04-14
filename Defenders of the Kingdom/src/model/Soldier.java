package model;

import java.util.ArrayList;

public class Soldier extends Unit
{
	
	private boolean attackflag;
	public Soldier()
	{
		name = "Soldier";
		attackRadius = 1;
		movementRadius = 2;
		health = 7;
		damage = 3;
		startingX = 0;
		startingY = 5;
		icon = 'S';
		attackflag = false;
	}
	
	//special power
	public void attackAll(ArrayList<Unit> unit){
		
		for(Unit u:unit)
			u.setDamage(2);
		this.attackflag=true;
		
	}
	
}
