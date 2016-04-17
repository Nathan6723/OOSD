package model;

public class FireLord extends Unit
{
	int lifelost;
	
	public FireLord() {
		
		name ="FireLord";
		attackRadius = 12;
		movementRadius = 5;
		health = 12;
		damage = 4;
		startingX = 3;
		startingY = 3;
		icon = 'F';
		teamName = "Villians";
	}

	public void specialAttack(int health,int lifelost){
     
		this.health =+ lifelost;
	}
	
	@Override
	public boolean moveUnit(Cell initialpos, Cell finalpos, Board b) {
		CheckMovement mov=	CheckMovement.getInstance();
		   if(  mov.negativehorizontal(initialpos, finalpos,this,b)|| mov.diagonal1(initialpos, finalpos,this,b)||mov.diagonal2(initialpos, finalpos,this,b)||mov.positivehorizontal(initialpos, finalpos,this,b)||mov.positiveVertical(initialpos, finalpos,this,b)||mov.negativeVertical(initialpos, finalpos,this,b))
			   return true;
		   else 
			   return false;
	}
	

}
