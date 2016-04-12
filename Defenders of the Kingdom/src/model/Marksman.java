package model;

public class Marksman extends Unit
{
	
	
	public Marksman(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	
	}
	
	
	public  int doubleDamage(int damage){
		return 2*damage;	
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
		int distance=xsteps-x;
	if(super.isAttack()){
		//checks movement is along vertical direction
		if(ysteps==0&&distance<5){
		//if(xsteps>x)
		super.setStartingX(xsteps);
		}
		return true;
	}
	else
		return false;
		
	}





	@Override
	public void useSpecialPower() {
		// TODO Auto-generated method stub
		
	}


	
}
