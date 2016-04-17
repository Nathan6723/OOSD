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
		@Override
		public boolean moveUnit(Cell initialpos, Cell finalpos, Board b) {
			CheckMovement mov=	CheckMovement.getInstance();
			   if(   mov.diagonal1(initialpos, finalpos,this,b)||mov.diagonal2(initialpos, finalpos,this,b)||mov.positiveVertical(initialpos, finalpos,this,b)||mov.negativeVertical(initialpos, finalpos,this,b))
				   return true;
			   else 
				   return false;

		}
		
		}
		
		


	

