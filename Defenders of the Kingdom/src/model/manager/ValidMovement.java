package model.manager;

import model.board.Cell;

public class ValidMovement
{
	public final static int DIRECTION_HORIZONTAL = 1;
	public final static int DIRECTION_VERTICAL = 2;
	public final static int DIRECTION_DIAGONAL = 4;
	
	public boolean isValidHorizontal(Cell initialCell, Cell finalCell, int movementRadius)
	{
		if (initialCell.getY() == finalCell.getY() && Math.abs((initialCell.getX() - finalCell.getX())) <= movementRadius)
			return true;
		else
			return false;
	}
	
	public boolean isValidVertical(Cell initialCell, Cell finalCell, int movementRadius)
	{
		if (initialCell.getX() == finalCell.getX() && Math.abs((initialCell.getY() - finalCell.getY())) <= movementRadius)
			return true;
		else
			return false;
	}
	
	public boolean isValidDiagonal(Cell initialCell, Cell finalCell, int movementRadius)
	{
		int xDiff = Math.abs((initialCell.getX() - finalCell.getX()));
		int yDiff = Math.abs((initialCell.getY() - finalCell.getY()));
		if (xDiff == yDiff && xDiff <= movementRadius)
			return true;
		else
			return false;
	}
}
