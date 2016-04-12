package model;

public class Avatar extends Unit
{
	
	private boolean shieldflag;
	public Avatar(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	
	
        
	 this.shieldflag=false;
	}
	
	
	
	

	public void useShield(){
     this.shieldflag=true;
		
	}





	@Override
	public boolean attack(Board b, Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public void useSpecialPower() {
		// TODO Auto-generated method stub
	    
		this.shieldflag=true;
	}





	@Override
	public boolean move(int xsteps, int ysteps) {
		int x=super.getStartingX();
		int y=super.getStartingY();
		int xdistance=xsteps-x;
		int ydistance=ysteps-y;
		if(xdistance<8&&xdistance>-8)
		super.setStartingX(xsteps);
		if(ydistance<8&&ydistance>-8)
		super.setStartingY(ysteps);
		return true;
		
	}















	
}