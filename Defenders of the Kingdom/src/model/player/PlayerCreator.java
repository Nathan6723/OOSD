package model.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import controller.BoardController;
import factory.WeaponFactory;
import model.board.Board;
import model.board.Cell;
import model.entity.Obstacle;
import model.team.Heroes;
import model.team.Villains;
import model.unit.Unit;
import model.weapon.AxeDecorator;
import model.weapon.BowDecorator;
import model.weapon.SpearDecorator;
import model.weapon.SwordDecorator;

public class PlayerCreator
{
	private Player[] players = new Player[2];
	private BoardController boardController;

	public PlayerCreator(BoardController boardController)
	{
		this.boardController = boardController;
		for (int i = 0; i < players.length; ++i)
			players[i] = new Player();
	}
	
	public boolean createPlayers()
	{
		for (int i = 0; i < players.length; ++i)
		{
			String name = null;
			do
			{
				name = boardController.getInput("Enter your name Player " + (i + 1) + ":");
				if (name == null)
					return false;
				name = name.trim();
			}
			while (name.equals(""));
			players[i].setName(name);
		}

		String[] options = new String[3];
		options[0] = "Heroes";
		options[1] = "Villains";
		options[2] = "Cancel";
		Random rand = new Random();
		int whichPlayer = rand.nextInt(players.length);
		int team = boardController.getChoice("Team", "Choose your team " + players[whichPlayer].getName() + ":", options);
		if (team == 0)
		{
			players[whichPlayer].setTeam(new Heroes());
			players[whichPlayer == 0 ? 1 : 0].setTeam(new Villains());
		}
		else if (team == 1)
		{
			players[whichPlayer].setTeam(new Villains());
			players[whichPlayer == 0 ? 1 : 0].setTeam(new Heroes());
		}
		else
			return false;
		for (int i = 0; i < players.length; ++i)
		{
			Iterator<Unit> iter = players[i].getTeam().getUnits().iterator();
			while (iter.hasNext())
				iter.next().setTeam(players[i].getTeam());
		}
		for (int i = 0; i < players.length; ++i)
		{
			Player player = players[i];
			ArrayList<Unit> units = player.getTeam().getUnits();
			for (Unit unit : units)
			{
				WeaponFactory weaponFactory = new WeaponFactory();
				while (!weaponFactory.hasCreated())
				{
					options = new String[4];
					options[0] = "Axe";
					options[1] = "Bow";
					options[2] = "Spear";
					options[3] = "Sword";
					int weapon = boardController.getChoice("Weapons", players[whichPlayer].getName() + 
							", which weapon would you like to add to " + unit.getName() + "?", options);
					if (weapon == 0)
						weaponFactory.addWeapon(AxeDecorator.class);
					else if (weapon == 1)
						weaponFactory.addWeapon(BowDecorator.class);
					else if (weapon == 2)
						weaponFactory.addWeapon(SpearDecorator.class);
					else if (weapon == 3)
						weaponFactory.addWeapon(SwordDecorator.class);
				}
				unit.setWeaponDecorator(weaponFactory.getWeapon());
			}
		}
		int obstaclesEnabled = boardController.getConfirm("Would you like to enable obstacles?", "Obstacles");
		if (obstaclesEnabled == JOptionPane.YES_OPTION)
		{
			Board board = boardController.getBoard();
			ArrayList<Cell> cells = new ArrayList<>();
			for (int i = 0; i < board.getX(); ++i)
				for (int j = 0; j < board.getY(); ++j)
					cells.add(board.getCell(i, j));
			int numObs = board.getX();
			ArrayList<Unit> units = new ArrayList<>();
			for (int i = 0; i < players.length; ++i)
				units.addAll(players[i].getTeam().getUnits());
			while (numObs > 0)
			{
				int whichCell = rand.nextInt(cells.size());
				Cell randCell = cells.get(whichCell);
				for (Unit unit : units)
					if (randCell.getX() == unit.getStartingX()
							&& randCell.getY() == unit.getStartingY())
						continue;
				randCell.setEntity(new Obstacle());
				cells.remove(whichCell);
				numObs -= 1;
			}
		}
		return true;
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
}
