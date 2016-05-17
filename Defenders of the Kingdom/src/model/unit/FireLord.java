package model.unit;

import model.Cell;

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
	
	public boolean isMoveValid(Cell initialCell, Cell finalCell)
	{
		return validMovement.isValidHorizontal(initialCell, finalCell, movementRadius)
				|| validMovement.isValidVertical(initialCell, finalCell, movementRadius)
				|| validMovement.isValidDiagonal(initialCell, finalCell, movementRadius);
	}

	public void specialAttack(int health,int lifelost){
     
		this.health =+ lifelost;
	}
	
	
}
