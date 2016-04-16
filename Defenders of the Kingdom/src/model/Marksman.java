package model;

public class Marksman extends Unit
{
	
	
	public Marksman() {
		
		name= "Marksman";
		attackRadius = 3;
		movementRadius = 2;
		health = 7;
		damage = 1;
		startingX = 4;
		startingY = 3;
		icon = 'M';
		teamName = "Villians";
	}
	public  int doubleDamage(int damage){
		return 2*damage;	
	}
	
	
}
