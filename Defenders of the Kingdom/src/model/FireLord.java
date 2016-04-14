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
	
	}

	public void specialAttack(int health,int lifelost){
     
		this.health =+ lifelost;
	}
	
	
}
