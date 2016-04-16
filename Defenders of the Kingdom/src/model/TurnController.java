package model;

public class TurnController
{
	private int turnNumber;
	
	//preconditions
	/*public boolean moveUnit(int x,int y,Board b)
	{   
		int length=b.getAllCells().length;
		if(x>length||y>length){
			System.out.println("movement cannot be outside the bound of the board ");
		return false;
		}
		
		
		return true;
	}*/
	
	public void incrementTurnNumber()
	{
		++turnNumber;
	}
	
	public int getTurnNumber(){
		return turnNumber;
	}
	public void setTurn(){

		if(turnNumber==0)
			turnNumber=3;

		else	if(turnNumber==3)
			turnNumber=1;

		else	if(turnNumber==1)
			turnNumber=4;

		else		if(turnNumber==4)
			turnNumber=2;
		else		if(turnNumber==2)
			turnNumber=5;
		else if(turnNumber==5)
			turnNumber=6;
		
	}
	
public Team setTeamTurn(Team t1,Team t2,Unit currentunit,Unit[] unit){

	Team t=t1;
	if(t1.getName().equalsIgnoreCase(currentunit.getTeam().getName())){
		
		t= t2;
	}
	else if(t2.getName().equalsIgnoreCase(currentunit.getTeam().getName())) {
		t=t1;
	}
	
	return t;
}
	
	public  void setTurnNumber(int t){
		 this.turnNumber=t;
	}
	
}