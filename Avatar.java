package model;

public class Avatar extends Unit
{
	
	private boolean alreadyUsedWithFireLord;
	private boolean alreadyUsedWithHenchman;
	private boolean alreadyUsedWithMarksman;
	
	
	public Avatar(){
	super();	
	name = "Avatar";
	attackRadius = 14;
	movementRadius = 5;
	health = 10;
	damage = 5;
	startingX = 3;
	startingY = 8;
	icon = 'A';
	teamName = "Heroes";
	}
	
	private void checkShieldAvailability (Unit opponent) {
		
		if(alreadyUsedWithFireLord && alreadyUsedWithHenchman && alreadyUsedWithMarksman) {
			
			System.out.println("You can't use the shield anymore");
			
		} else {
		
		
		if (opponent instanceof FireLord) {
			
			if(!alreadyUsedWithFireLord) {
				
				this.specialAttack(opponent);
				
				this.alreadyUsedWithFireLord = true;
				
				
			} else if (opponent instanceof Henchman) {
				
				if(!alreadyUsedWithHenchman) {
					
					this.specialAttack(opponent);
					
					this.alreadyUsedWithHenchman = true;
					
					
				}
				
				
			} else if (opponent instanceof Marksman) {
				
				if(!alreadyUsedWithMarksman) {
					
					this.specialAttack(opponent);
					
					this.alreadyUsedWithMarksman = true;
					
					
				}
			}
		 }
	  }
		
	}
	
	
	public void specialAttack(Unit opponent) {
		
		this.health = this.health + opponent.getHealth();
		
	}
	@Override
	public boolean moveUnit(Cell initialpos, Cell finalpos, Board b) {
		CheckMovement mov=	CheckMovement.getInstance();
		if(  mov.negativehorizontal( initialpos, finalpos,this,b)|| mov.diagonal1(initialpos, finalpos,this,b)||mov.diagonal2(initialpos, finalpos,this,b))
			   return true;
		   else 
			   return false;
	}
	

	
}
