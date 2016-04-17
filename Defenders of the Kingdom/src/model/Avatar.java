package model;

public class Avatar extends Unit
{
	
	private boolean alreadyUsedWithFireLord;
	private boolean alreadyUsedWithHenchman;
	private boolean alreadyUsedWithMarksman;
	
	public Avatar()
	{
		name = "Avatar";
		attackRadius = 14;
		movementRadius = 5;
		health = 10;
		damage = 5;
		startingX = 6;
		startingY = 9;
		icon = 'A';
	}
	
	public boolean isMoveValid(Cell initialCell, Cell finalCell)
	{
		return validMovement.isValidHorizontal(initialCell, finalCell, movementRadius)
				|| validMovement.isValidVertical(initialCell, finalCell, movementRadius)
				|| validMovement.isValidDiagonal(initialCell, finalCell, movementRadius);
	}
	
	@SuppressWarnings("unused")
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
	
	
}
