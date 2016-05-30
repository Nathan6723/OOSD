package model.board;

import java.util.Observable;

import model.entity.Entity;

public class Cell extends Observable
{
	private int x;
	private int y;
	private Entity entity;
	private boolean currentCell;
	private boolean potentialCell;

	public Cell() {}
	
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	private void updateObserver()
	{
		setChanged();
		notifyObservers();
	}
	
	public boolean isCurrentCell()
	{
		return currentCell;
	}

	public void setCurrentCell(boolean currentCell)
	{
		this.currentCell = currentCell;
		updateObserver();
	}

	public boolean isPotentialCell()
	{
		return potentialCell;
	}

	public void setPotentialCell(boolean potentialCell)
	{
		this.potentialCell = potentialCell;
		updateObserver();
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
		updateObserver();
	}
}
