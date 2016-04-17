package model;



public class CheckMovement  {
	
	private int x1=0,y1=0,x2=0,y2=0,movementradius=0;
	private static CheckMovement instance = null;
	Moveunit  move;
	private CheckMovement(){
		
	}
	
	public static CheckMovement getInstance()
	{
		if (instance == null){
			 
			return new CheckMovement();
			}
		return instance;
	}
	
	
	public boolean move(Cell initialpos,Cell finalpos){
move=Moveunit.getInstance();
return move.Move(initialpos, finalpos);
	}
	
	public boolean positivehorizontal(Cell initialpos,Cell finalpos,Unit unit,Board board){
  x1=initialpos.getX();
 y1=initialpos.getY();
 x2=finalpos.getX();
 y2=finalpos.getY();

 movementradius=unit.getMovementRadius();
if(board.checkDistance(initialpos, finalpos)){
		if(y1==y2&&x2>x1){
			int end=x1+movementradius;
			for(int x=x1;x<=end;x++){
				if( board.checkBounds(x, 0)){
				if(x==x2){
					if(move(initialpos,finalpos))
					return true;}
			}
			}
		}
	
		}
		return false;
	}
	
public boolean negativehorizontal(Cell initialpos,Cell finalpos,Unit unit,Board board){
	
 x1=initialpos.getX();
 y1=initialpos.getY();
 x2=finalpos.getX();
 y2=finalpos.getY();
 movementradius=unit.getMovementRadius();
 if(board.checkDistance(initialpos, finalpos)){
		if(y1==y2&&x1>x2){
			int end=x1-movementradius;
			for(int x=x1;x>=end;x--){
				if( board.checkBounds(x, 0)){
				if(x==x2){
					if(move(initialpos,finalpos))
					return true;}
			
			}
			}
		}
		
 }
		return false;
	}
	
	
	public boolean positiveVertical(Cell initialpos,Cell finalpos,Unit unit,Board board){
		
	          x1=initialpos.getX();
                 y1=initialpos.getY();
               x2=finalpos.getX();
              y2=finalpos.getY();	
              movementradius=unit.getMovementRadius();
              if(board.checkDistance(initialpos, finalpos)){
		if(x1==x2&&y2>y1){
			int end=y1+movementradius;
			for(int y=y1;y<=end;y++){
				if( board.checkBounds(0,y)){
				if(y==y2){
					if(move(initialpos,finalpos))
					return true;}
			}
			}
		}
              }
		return false;
		
	}
	
	
public boolean negativeVertical(Cell initialpos,Cell finalpos,Unit unit,Board board){
	           x1=initialpos.getX();
                 y1=initialpos.getY();
               x2=finalpos.getX();
              y2=finalpos.getY();
              movementradius=unit.getMovementRadius();
              if(board.checkDistance(initialpos, finalpos)){
		if(x1==x2&&y1>y2){
			int end=y1-movementradius;
			for(int y=y1;y>=end;y--){
				if( board.checkBounds(0,y)){
				if(y==y2){
					if(move(initialpos,finalpos))
					return true;}
			}
			}
		}
              }
		return false;	
		
	}

public boolean diagonal1(Cell initialpos,Cell finalpos,Unit unit,Board board){
         x1=initialpos.getX();
                 y1=initialpos.getY();
               x2=finalpos.getX();
              y2=finalpos.getY();	
              movementradius=unit.getMovementRadius();
boolean p=false;
	int i=0;
	int j=0;
	int xend=0;
	int yend=0;
	

		// x+ y+
	if(board.checkDistance(initialpos, finalpos)){
	xend=x1+movementradius;
	for(int x=x1;x<=xend;x++){
		i++;
		if( board.checkBounds(x,0)){
		if(x==x2)
			break;		
		}
	}
	
	yend=y1+movementradius;
	for(int y=y1;y<=yend;y++){
		j++;
		if( board.checkBounds(0,y)){
		if(y==y2)
			break;	
		}
	}
	
	if(i==j)
	{
		if(move(initialpos,finalpos))
		return true;}
	
	//x-y-
	xend=x1-movementradius;
	yend=y1-movementradius;
	i=0;
	for(int x=x1;x>=xend;x--){
		i++;
	if( board.checkBounds(x,0)){
		if(x==x2)
      break;
	}
	}
	
	 j=0;
	for(int y=y1;y>=yend;y--){
		j++;
	if( board.checkBounds(0,y)){
		if(y==y2)
      break;
	}
	}
	
	if(i==j)
	{
		if(move(initialpos,finalpos))
		return true;}
	}
	return false;
}

public boolean diagonal2(Cell initialpos,Cell finalpos,Unit unit,Board board){
               x1=initialpos.getX();
                 y1=initialpos.getY();
               x2=finalpos.getX();
              y2=finalpos.getY();	
              movementradius=unit.getMovementRadius();
boolean p=false;
	int i=0;
	int j=0;
	int xend=0;
	int yend=0;
	

		// x- y+
	if(board.checkDistance(initialpos, finalpos)){
	xend=x1-movementradius;
	for(int x=x1;x>=xend;x--){
		i++;
		if( board.checkBounds(x,0)){
		if(x==x2)
			break;		
		}
	}
	
	yend=y1+movementradius;
	for(int y=y1;y<=yend;y++){
		j++;
		if( board.checkBounds(0,y)){
		if(y==y2)
			break;	
		}
	}
	
	if(i==j)
	{
		if(move(initialpos,finalpos))
		return true;}
	
	//x+y-
	xend=x1+movementradius;
	yend=y1-movementradius;
	i=0;
	for(int x=x1;x<=xend;x++){
		i++;
	if( board.checkBounds(x,0)){
		if(x==x2)
      break;
	}
	}
	
	 j=0;
	for(int y=y1;y>=yend;y--){
		j++;
	if( board.checkBounds(0,y)){
		if(y==y2)
      break;
	}
	}
	
	if(i==j)
	{
		if(move(initialpos,finalpos))
		return true;}
	}
	return false;
}




	
}
