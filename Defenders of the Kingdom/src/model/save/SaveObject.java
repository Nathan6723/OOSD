package model.save;

import model.board.Cell;
import model.manager.Movement;
import model.manager.Turn;

public class SaveObject
{
	public Cell[][] cells;
	public Turn turn;
	public Movement movement;
	public String timer;
	public String timeLimit;
	public boolean dragAndDrop;
	public String messages;
}
