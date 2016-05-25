package model.unit;

import model.board.Cell;

public class Marksman extends Unit
{
	public Marksman()
	{	
		name= "Marksman";
		attackRadius = 3;
		movementRadius = 2;
		health = 7;
		damage = 1;
		startingX = 7;
		startingY = 1;
		icon = 'M';
	}
	
	public boolean isMoveValid(Cell initialCell, Cell finalCell)
	{
		return validMovement.isValidDiagonal(initialCell, finalCell, movementRadius)
				|| validMovement.isValidVertical(initialCell, finalCell, movementRadius);
	}
	
	public int doubleDamage(int damage)
	{
		return 2*damage;	
	}
}
