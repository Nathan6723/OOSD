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
	
	
}
