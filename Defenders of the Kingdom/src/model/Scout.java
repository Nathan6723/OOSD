package model;



public class Scout extends Unit
{
	
	private boolean attackflag;

	public Scout(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{ 
		super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	}

	
	
//attacks anyone at any distance
	public void attackAnyDistance(){
		
		attackflag=true;
		
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
		if(ysteps==0&&distance<4){
		if(xsteps>x)
		super.setStartingX(x+xsteps);
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
	
