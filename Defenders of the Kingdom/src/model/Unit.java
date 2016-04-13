package model;

import java.util.Scanner;

public abstract class Unit implements Object
{  
	private String name;
	private int health;
	private int damage;
	private boolean meleeAttack;
	private int startingX;
	private int startingY;
	private char icon;
	private int attackRadius;
	private Team team;
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



	
	public Team getTeam() {
		return team;
	}




	public void setTeam(Team team) {
		this.team = team;
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
	
	public abstract boolean isValidMove(int x1,int y1,int x2,int y2); 
	
	
	public void decrementHealth(int damage){
	health=health-damage;
	}
	
	public abstract boolean move(int xsteps,int ysteps);
	public  boolean attack(Board b,Unit unit)
	{
		boolean p=false;
	 Scanner sc=new Scanner(System.in);
		if(isAttack()){
	Unit[] u=new Unit[81];
	  int  negvertical=0;
    int  vertical=unit.getStartingX()+unit.attackRadius;
    int horizontal=unit.getStartingY()+unit.attackRadius;
    		
    if(unit.getStartingX()>unit.attackRadius)
         negvertical=unit.getStartingX()-unit.attackRadius;
    		else
    			 negvertical=unit.attackRadius-unit.getStartingX();
    int neghorizontal=0;
        
    if(unit.getStartingY()>unit.attackRadius)
    	neghorizontal=unit.getStartingY()-unit.attackRadius;
   		else
   			neghorizontal=unit.attackRadius-unit.getStartingY();
   		
       
    	
   
    		
    		//fire in positive vertical direction 
    for(int i=unit.getStartingX();i<vertical;i++){
    	 if(b.checkBounds(i,unit.getStartingY())){
 			Cell[][] c=b.getAllCells();
 			 if(c[i][unit.getStartingY()].getUnit()!=null&&c[i][unit.getStartingY()].getUnit().getTeam().getName()!=unit.getTeam().getName()){	     
 				u[i]=c[i][unit.getStartingY()].getUnit(); 
 			 }
 		 }
    	 else
			  break;
    	
    }
   //fire in positive horizontal direction
    
    for(int j=unit.getStartingY();j<horizontal;j++){
   	 if(b.checkBounds(unit.getStartingX(),j)){
			Cell[][] c=b.getAllCells();
			 if(c[unit.getStartingX()][j].getUnit()!=null&&c[unit.getStartingX()][j].getUnit().getTeam().getName()!=unit.getTeam().getName()){	     
				u[j]=c[unit.getStartingX()][j].getUnit(); 
			 }
			 else
			  break;	 
		 }
   	
   }
    
    
    //fire  in negative vertical direction
    for(int i=unit.getStartingX();i>negvertical;i--){
           //int x=(2*-i)+i;
    	if(b.checkBounds(i,unit.getStartingY())){
			Cell[][] c=b.getAllCells();
			 if(c[i][unit.getStartingY()].getUnit()!=null&&c[i][unit.getStartingY()].getUnit().getTeam().getName()!=unit.getTeam().getName()){	     
				u[i]=c[i][unit.getStartingY()].getUnit(); 
			 }
		 }
    	 else
			  break;
   	
   }
    
    
   //fire in negative horizontal direction
    
    for(int j=unit.getStartingY();j>neghorizontal;j--){
   	 if(b.checkBounds(unit.getStartingX(),j)){
			Cell[][] c=b.getAllCells();
			 if(c[unit.getStartingX()][j].getUnit()!=null&&c[unit.getStartingX()][j].getUnit().getTeam().getName()!=unit.getTeam().getName()){	     
				u[j]=c[unit.getStartingX()][j].getUnit(); 
			 }
		 }
   	 else
		  break;
   	
   }
    
       	
    	
		if(u!=null){
			int k=0;
		for(int i=0;i<u.length;i++){
		if(u[i]!=null){
			k++;
		System.out.println("Following opponents are in your range "+i+"."+u[i].getName());
		}
		}
		
		if(k!=0){
		System.out.println("whom do you want to attack choose  the line number");
		
	
	  int opponent=sc.nextInt();
	  System.out.println(opponent);

		
	  //opponent--;
	  u[opponent].setHealth(u[opponent].getHealth()-unit.getDamage());
	  System.out.println("Remaining Health of " + u[opponent].getName()+" is"+  u[opponent].getHealth());
p=true;
		}
}
		
		
	
		
		}

			else{
				 System.out.println("no one within the  attack radius");
		p= false;
			}
	

	
		
		return p;
		//return  true;
	}
	
	public abstract void useSpecialPower();
		
	
	
	public int getStartingX()
	{
		return startingX;
	}
	
	public int getStartingY()
	{
		return startingY;
	}
}
