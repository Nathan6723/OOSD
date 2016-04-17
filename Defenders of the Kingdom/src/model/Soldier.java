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
		startingX = 1;
		startingY = 5;
		icon = 'S';
		attackflag = false;
		teamName = "Heroes";
	}
	
	//special power
	public void attackAll(ArrayList<Unit> unit){
		
		for(Unit u:unit)
			u.setDamage(2);
		this.attackflag=true;
		
	}
	@Override
	public boolean moveUnit(Cell initialpos, Cell finalpos, Board b) {
		CheckMovement mov=	CheckMovement.getInstance();
		
		   if(  mov.negativehorizontal(initialpos, finalpos,this,b)||mov.positivehorizontal(initialpos, finalpos,this,b)||mov.positiveVertical(initialpos, finalpos,this,b)||mov.negativeVertical(initialpos, finalpos,this,b))
			   return true;
		   else 
			   return false;

	}

	
}
