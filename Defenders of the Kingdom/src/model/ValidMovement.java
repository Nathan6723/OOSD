package model;

public class ValidMovement
{
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
