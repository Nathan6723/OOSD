package model;

public class FireLord extends Unit
{
	
	
	public FireLord(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	
	}

	public int recoverLife(int currentlife,int lifelost){
     
		return  (currentlife+lifelost);
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
		if(xdistance<6&&xdistance>-6)
		super.setStartingX(xsteps);
		if(ydistance<6&&ydistance>-6)
		super.setStartingY(ysteps);
		return true;
		
	}

	@Override
	public void useSpecialPower() {
		// TODO Auto-generated method stub
		
	}


	
	
}