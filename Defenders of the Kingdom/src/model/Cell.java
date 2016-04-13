package model;

public class Cell
{
	private int x;
	private int y;
	private Object object;
	private Unit   unit;
	
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setObject(Object object)
	{
		this.object = object;
	}
	
	public Object getObject()
	{
		return object;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
