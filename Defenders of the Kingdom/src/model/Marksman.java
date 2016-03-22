package model;

public class Marksman extends Unit
{
	private boolean meleeAttack;
	private char icon;
	
	public Marksman()
	{
		meleeAttack = false;
		icon = 'm';
	}

	public char getIcon() {
		return icon;
	}

	public void setIcon(char icon) {
		this.icon = icon;
	}
}
