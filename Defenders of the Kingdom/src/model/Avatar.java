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
	public void useSpecialPower() {
		// TODO Auto-generated method stub
	    
		this.shieldflag=true;
		
	}





	@Override
	public boolean move(int xsteps, int ysteps) {
		
		/*int x=super.getStartingX();
		int y=super.getStartingY();
		int xdistance=xsteps-x;
		int ydistance=ysteps-y;
		isValidMove(x,y,xsteps,ysteps);
		if(xdistance<8&&xdistance>-8)
		super.setStartingX(xsteps);
		if(ydistance<8&&ydistance>-8)
		super.setStartingY(ysteps);*/
		int x=super.getStartingX();
		int y=super.getStartingY();
		
		if(isValidMove(x,y,xsteps,ysteps)){
			super.setStartingX(xsteps);
			super.setStartingY(ysteps);
			return true;
		}
		else
			return false;
	
		
	}





	@Override
	public boolean isValidMove(int x1,int y1,int x2,int y2) {
		boolean p=true;
		int xdistance=x2-x1;
		int ydistance=y2-y1;
		if(xdistance<8&&xdistance>-8)
             {
            	if((ydistance<8&&ydistance>-8))
            		p=true;
                  }
	return p;
		
			}















	
}
