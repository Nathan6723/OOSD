package model;

public class Henchman extends Unit
{
	private boolean meleeAttack;
	private char icon;
	
	public Henchman()
	{
		meleeAttack = true;
		icon = 'h';
	}

	public char getIcon() {
		return icon;
	}

	public void setIcon(char icon) {
		this.icon = icon;
	}
}
