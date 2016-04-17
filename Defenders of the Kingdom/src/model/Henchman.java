package model;

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
	
	public boolean isMoveValid(Cell cell1, Cell cell2)
	{
		return validMovement.isValidDiagonal(cell1, cell2, movementRadius);
	}


public int doubleAttackRadius(int r ){
	return 2*r;
	
}


	

}
