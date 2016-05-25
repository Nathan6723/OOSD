package model.unit;
import java.util.Scanner;

import model.board.Cell;

public class Scout extends Unit
{	
	public Scout()
	{
		name = "Scout";
		attackRadius = 2;
		movementRadius = 3;
		health = 3;
		damage = 2;
		startingX = 9;
		startingY = 7;
		icon = 'C';
	}
	
	public boolean isMoveValid(Cell initialCell, Cell finalCell)
	{
		return validMovement.isValidVertical(initialCell, finalCell, movementRadius)
				|| validMovement.isValidHorizontal(initialCell, finalCell, movementRadius);
	}
	
	@SuppressWarnings("unused")
	public void specialAttack(){
		
		System.out.println("Choose any Villian on the board to attack");
		
		Scanner sc = new Scanner(System.in);
			int opponentX = sc.nextInt();
			
			int opponentY = sc.nextInt();
			
		
			// Unit opponent;

			this.cannotUseSpecialPower = true;
			
		sc.close();
	}
}
