package model;

public class Cell
{
	private int x;
	private int y;
	private Entity entity;
	
	public Cell() {}
	
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public Entity getEntity()
	{
		return entity;
	}
	
	public void setEntity(Entity entity)
	{
		this.entity = entity;
	}
}
