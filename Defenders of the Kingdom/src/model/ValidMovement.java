package model;

public class ValidMovement
{
	public boolean isValidHorizontal(Cell cell1, Cell cell2, int movementRadius)
	{
		if (cell1.getX() == cell2.getX() && Math.abs((cell1.getY() - cell2.getY())) <= movementRadius)
			return true;
		else
			return false;
	}
	
	public boolean isValidVertical(Cell cell1, Cell cell2, int movementRadius)
	{
		if (cell1.getY() == cell2.getY() && Math.abs((cell1.getX() - cell2.getX())) <= movementRadius)
			return true;
		else
			return false;
	}
	
	public boolean isValidDiagonal(Cell cell1, Cell cell2, int movementRadius)
	{
		int xDiff = Math.abs((cell1.getX() - cell2.getX()));
		int yDiff = Math.abs((cell1.getY() - cell2.getY()));
		if (xDiff == yDiff && xDiff <= movementRadius)
			return true;
		else
			return false;
	}
}
