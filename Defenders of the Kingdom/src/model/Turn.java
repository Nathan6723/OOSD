package model;

public class Turn
{
	private int turnNumber;
	private int currentPlayer = 0;
	private boolean playerInit = false;
	private boolean nameChosen = false;
	private Player[] players = new Player[2];
	private int stage;

	public String getNextMessage()
	{
		String message = null;
		if (!playerInit)
		{
			if (!nameChosen)
			{
				message = "Enter your name Player " + ++currentPlayer + ":";
				if (currentPlayer == players.length)
				{
					nameChosen = true;
					currentPlayer = 0;
				}
			}
			else
			{
				
				if (++currentPlayer == players.length)
					playerInit = true;
			}
		}
		else
		{
			
		}
		return message;
	}
	
	public void processInput(String input)
	{
		if (!playerInit)
		{
			if (!nameChosen)
				players[currentPlayer - 1].setName(input);
			else
			{
				
			}
		}
		players[0].setTeam(new Heroes());
		players[1].setName("ADHG");
		players[1].setTeam(new Villians());
	}
	
	public void incrementTurnNumber()
	{
		++turnNumber;
	}
	
	public int getTurnNumber()
	{
		return turnNumber;
	}
}