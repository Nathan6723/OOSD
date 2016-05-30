package model.manager;

import model.board.Cell;

public class ValidDirection
{
	public final static int DIRECTION_HORIZONTAL = 1;
	public final static int DIRECTION_VERTICAL = 2;
	public final static int DIRECTION_DIAGONAL = 4;
	
	public boolean isValidDirection(int direction, Cell initialCell, Cell finalCell, int radius)
	{
		boolean isValid = false;
		if ((direction & DIRECTION_HORIZONTAL) == DIRECTION_HORIZONTAL)
			isValid = isValid || isValidHorizontal(initialCell, finalCell, radius);
		if ((direction & DIRECTION_VERTICAL) == DIRECTION_VERTICAL)
			isValid = isValid || isValidVertical(initialCell, finalCell, radius);
		if ((direction & DIRECTION_DIAGONAL) == DIRECTION_DIAGONAL)
			isValid = isValid || isValidDiagonal(initialCell, finalCell, radius);
		return isValid;
	}
	
	private boolean isValidHorizontal(Cell initialCell, Cell finalCell, int movementRadius)
	{
		if (initialCell.getY() == finalCell.getY() && Math.abs((initialCell.getX() - finalCell.getX())) <= movementRadius)
			return true;
		else
			return false;
	}
	
	private boolean isValidVertical(Cell initialCell, Cell finalCell, int movementRadius)
	{
		if (initialCell.getX() == finalCell.getX() && Math.abs((initialCell.getY() - finalCell.getY())) <= movementRadius)
			return true;
		else
			return false;
	}
	
	private boolean isValidDiagonal(Cell initialCell, Cell finalCell, int movementRadius)
	{
		int xDiff = Math.abs((initialCell.getX() - finalCell.getX()));
		int yDiff = Math.abs((initialCell.getY() - finalCell.getY()));
		if (xDiff == yDiff && xDiff <= movementRadius)
			return true;
		else
			return false;
	}
}
