package model.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.board.Board;
import model.entity.Entity;
import model.team.Team;
import model.unit.Unit;

public class VictoryConditions
{
	@JsonIgnore
	private Board board;
	
	public static final String VICTORY_MESSAGE = " has won the game!";

	public VictoryConditions(Board board)
	{
		this.board = board;
	}

	public boolean checkVictory()
	{
		Team team = null;
		boolean teamsExist = true;
		loops:
		for (int i = 0; i < board.getX(); ++i)
		{
			for (int j = 0; j < board.getY(); ++j)
			{
				Entity entity = board.getCell(i, j).getEntity();
				if (entity instanceof Unit)
				{
					Unit unit = (Unit)entity;
					if (team == null)
					{
						team = unit.getTeam();
						continue;
					}
					if (unit.getTeam() != team)
					{
						teamsExist = false;
						break loops;
					}
				}
			}
		}
		return teamsExist;
	}
}
