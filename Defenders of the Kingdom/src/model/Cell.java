package model;

public class Cell
{
	private int x;
	private int y;
	private Object object;
	
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
}
