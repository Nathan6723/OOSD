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



	@Override
	public boolean attack(Board b, Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}



	

	@Override
	public boolean move(int xsteps, int ysteps) {
		int x=super.getStartingX();
		int y=super.getStartingY();
		int xdistance=xsteps-x;
		int ydistance=ysteps-y;
		boolean p=false;
		//moving forward
		if(xdistance>0&&xdistance<7){
		super.setStartingX(xsteps);
    p= true;
		}
		if(ydistance>0&&ydistance<7){
		super.setStartingY(ysteps);
p=true;
		}
		
		return p;
	}


	@Override
	public void useSpecialPower() {
		// TODO Auto-generated method stub
		
	}
	
}