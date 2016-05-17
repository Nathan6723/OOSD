package model.unit;

import model.Cell;

public class Henchman extends Unit
{
	public Henchman()
	{
		name= "Henchman";
		attackRadius = 3;
		movementRadius = 2;
		health = 9;
		damage = 4;
		startingX = 2;
		startingY = 4;
		icon = 'H';
	}
	
	public boolean isMoveValid(Cell initialCell, Cell finalCell)
	{
		return validMovement.isValidDiagonal(initialCell, finalCell, movementRadius);
	}

public int doubleAttackRadius(int r ){
	return 2*r;
	
}


	

}
