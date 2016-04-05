package model;

import java.util.Scanner;

public class Unit implements Object
{
	private String name;
	private int health;
	private int damage;
	private boolean meleeAttack;
	private int startingX;
	private int startingY;
	private char icon;
	private int attackRadius;
	public Unit(String name,int attackRadius, int health, int damage, boolean meleeAttack, int startingX, int startingY,char icon) {
	
		this.name = name;
		
		this.health = health;
		this.damage = damage;
		this.meleeAttack = meleeAttack;
		this.startingX = startingX;
		this.startingY = startingY;
		this.icon=icon;
	    this.attackRadius=attackRadius;
	}



	
	public int getAttackRadius() {
		return attackRadius;
	}




	public void setAttackRadius(int attackRadius) {
		this.attackRadius = attackRadius;
	}




	public char getIcon() {
		return icon;
	}




	public void setIcon(char icon) {
		this.icon = icon;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isMeleeAttack() {
		return meleeAttack;
	}

	public void setMeleeAttack(boolean meleeAttack) {
		this.meleeAttack = meleeAttack;
	}

	public void setStartingX(int startingX) {
		this.startingX = startingX;
	}

	public void setStartingY(int startingY) {
		this.startingY = startingY;
	}

	public boolean move(int x, int y)
	{
		this.startingX = x;
		this.startingY =y;
		return true;
	}
	
	public boolean attack(int x, int y)
	{
	
		return true; 
	}
	
	public boolean isAttack(){
		if(this.health>0)
		return true;
		else{
		System.out.println("unit is dead ");
			return false;
		}
	}
	
	public boolean attack(Board b,Unit unit){
		boolean p=false;
		if(isAttack()){
	Unit[] u=new Unit[3];
		for(int i=0;i<unit.attackRadius;i++){
		 for(int j=0;j<unit.attackRadius;j++){
			Cell[][] c=b.getAllCells();
			 if(c[i][j].getUnit()!=null){
				u[i]=c[i][j].getUnit(); 
			 }
		 }
	 }
		if(u!=null){
		for(int i=0;i<u.length;i++){
		if(u[i]!=null)
		System.out.println("Following opponents are in your range "+i+"."+u[i]);
		}
		System.out.println("whom do you want to attack choose  the line number");
		Scanner sc=new Scanner(System.in);
	  int opponent=sc.nextInt();
	  sc.close();
	  opponent--;
	  u[opponent].setHealth(u[opponent].getHealth()-this.getDamage());
	  System.out.println("Reamining Health of " + u[opponent].getName()+" is"+  u[opponent].getHealth());
p=true;
		}
		
	
		
		}

			else{
				 System.out.println("no one within the  attack radius");
		p= false;
			}
	

		return p;
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
