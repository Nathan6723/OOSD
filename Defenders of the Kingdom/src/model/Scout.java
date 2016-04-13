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
	public boolean move(int xsteps, int ysteps) {
		int x=super.getStartingX();
		int y=super.getStartingY();
		int distance=0;
		if(xsteps>x)
		 distance=xsteps-x;
		else
			distance=x-xsteps;
		
		if(super.isAttack()){
		//checks movement is along vertical direction
		if(ysteps==0&&distance<4){
	//	if(xsteps>x)
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



	@Override
	public boolean isValidMove(int x1,int y1,int x2,int y2) {
		// TODO Auto-generated method stub
		return false;
	}
	}
	

