package model;

public class Henchman extends Unit
{

	
	public Henchman(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon)
	{  super(name,attackRadius,health,damage,meleeAttack,startingX, startingY,icon);
	
	}


public int doubleAttackRadius(int r ){
	return 2*r;
	
}


@Override
public boolean move(int xsteps, int ysteps) {
	int x=super.getStartingX();
	int y=super.getStartingY();
	int xdistance=xsteps-x;
	int ydistance=ysteps-y;
     if(super.isAttack()){
	if(xsteps<x&&ysteps<y){
	if(xdistance>-7&ydistance>-7){
      super.setStartingX(xsteps);
      super.setStartingY(ysteps);
	return true;	
	}	
	}
	
	if(xsteps<x&&ysteps>y){
	if(xdistance>-7&ydistance<7){
      super.setStartingX(xsteps);
      super.setStartingY(ysteps);
	return true;	
	}	
	}
	
	
	
     }
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
