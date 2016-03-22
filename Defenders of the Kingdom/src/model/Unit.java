package model;

public class Unit implements Object
{
	private String name;
	private int health;
	private int damage;
	private boolean meleeAttack;
	private int startingX;
	private int startingY;
	
	public boolean move(int x, int y)
	{
		
		return true;
	}
	
	public boolean attack(int x, int y)
	{
		
		return true;
	}
	
	public int getStartingX()
	{
		return startingX;
	}
	
	public int getStartingY()
	{
		return startingY;
	}
}
