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
		startingX = 4;
		startingY = 2;
		icon = 'F';
	}
	
	public boolean isMoveValid(Cell cell1, Cell cell2)
	{
		return validMovement.isValidHorizontal(cell1, cell2, movementRadius);
	}

	public void specialAttack(int health,int lifelost){
     
		this.health =+ lifelost;
	}
	
	
}
